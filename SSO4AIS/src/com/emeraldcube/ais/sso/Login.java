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
public class Login {

    /**
     * @param e1User String
     * @return LoginEnvironment
     *
     */
    public static LoginEnvironment getLoginAIS(String e1User) {
        return getLoginAIS(e1User, null, null, null);
    }

    /**
     * @param e1User String
     * @param e1UserRole
     * @return LoginEnvironment
     *
     */
    public static LoginEnvironment getLoginAIS(String e1User, String e1UserRole) {
        return getLoginAIS(e1User, e1UserRole, null, null);
    }

    /**
     * @param e1User String
     * @param e1UserRole
     * @param e1Environment
     * @return LoginEnvironment
     *
     */
    public static LoginEnvironment getLoginAIS(String e1User, String e1UserRole, String e1Environment) {
        return getLoginAIS(e1User, e1UserRole, e1Environment, null);
    }

    /**
     * @param e1User String
     * @param e1UserRole
     * @param e1Environment
     * @param capabilityList
     * @return LoginEnvironment
     *
     */
    public static LoginEnvironment getLoginAIS(String e1User, String e1UserRole, String e1Environment, String capabilityList) {
        LoginEnvironment lEnv = null;

        if (e1UserRole == null || e1UserRole.isEmpty()) {
            e1UserRole = Constants.DEFAULT_JDE_USER_ROLE;
        }

        if (e1Environment == null || e1Environment.isEmpty()) {
            e1Environment = Constants.DEFAULT_JDE_ENVIRONMENT;
        }

        if (capabilityList == null || capabilityList.isEmpty()) {
            capabilityList = Constants.DEFAULT_JDE_CAPABILITY_LIST;
        }

        try {
            Logger.l("Performing token authentication for user " + e1User);
            // Obtain token for user and log in
            lEnv = new LoginEnvironment(Constants.AIS_SERVER_URL, e1User, null, e1Environment, e1UserRole, Constants.DEVICE, capabilityList, null, getE1Token(e1User));
            Logger.l("User " + e1User + " logged in with Session ID " + lEnv.getJSessionId());
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

        return lEnv;
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
