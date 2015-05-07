/*
 * The MIT License
 *
 * Copyright 2015 EmeraldCube Solutions, LLC.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.emeraldcube.ais.sso;

import com.emeraldcube.ais.tools.Logger;
import com.oracle.e1.aisclient.CapabilityException;
import com.oracle.e1.aisclient.JDERestServiceException;
import com.oracle.e1.aisclient.LoginEnvironment;
import com.peoplesoft.base.TokenGenerator;
import com.peoplesoft.base.TokenGeneratorException;
import com.peoplesoft.base.TokenGeneratorFactory;
import java.io.IOException;
import java.util.Locale;


/**
 * @author mtamassia Created on May 7, 2015 3:27:51 PM
 */
public class E1Token {

    private static final String AIS_SERVER_URL = "http://91web.cloud.emeraldcube.net:8183";
    private static final String DEVICE = "Java";
    private static final String JDE_ENVIRONMENT = "JDV910";
    private static final String JDE_USER_ROLE = "*ALL";
    private static final String JDE_CAPABILITY_LIST = "grid,editable,log,processingOption,ignoreFDAFindOnEntry,selectAllGridRows,thumbnailSize,gridCellClick,query,urlMediaObjects";

    public static void main(String[] args) {
        getLoginAIS("DVIGGIANI");
    }

    /**
     * @param e1User String
     * @return LoginEnvironment
     *
     */
    private static LoginEnvironment getLoginAIS(String e1User) {
        LoginEnvironment loginEnv = null;

        try {
            Logger.l("Performing token authentication for user " + e1User);
            // Obtain token for user and log in
            loginEnv = new LoginEnvironment(AIS_SERVER_URL, e1User, null, JDE_ENVIRONMENT, JDE_USER_ROLE, DEVICE, JDE_CAPABILITY_LIST, null, getE1Token(e1User));
            Logger.l("User " + e1User + " logged in with Session ID " + loginEnv.getJSessionId());
        } catch (CapabilityException ex) {
            Logger.l("Capability Exception");
            Logger.l(ex);
        } catch (IOException ex) {
            Logger.l("IO Exception");
            Logger.l(ex);
        } catch (JDERestServiceException ex) {
            Logger.l("JDE REST Exception");
            Logger.l(ex);
        }

        return loginEnv;
    }

    /**
     * @param e1User String
     * @return String with valid JDE E1 token
     *
     */
    private static String getE1Token(String e1User) {
        String token = "";
        try {
            TokenGenerator tGen = TokenGeneratorFactory.getTokenGenerator();
            token = tGen.generateToken(e1User, Locale.US);
        } catch (TokenGeneratorException ex) {
            Logger.l(ex);
        }

        return token;
    }
}
