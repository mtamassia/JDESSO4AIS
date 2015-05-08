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
package com.emeraldcube.ais.sample.addressbook;

import com.emeraldcube.ais.objects.p01012.P01012_W01012B_FormParent;
import com.emeraldcube.ais.objects.p01012.P01012_W01012B_GridRow;
import com.emeraldcube.ais.sso.Login;
import com.emeraldcube.ais.tools.Logger;
import com.oracle.e1.aisclient.AISClientUtilities;
import com.oracle.e1.aisclient.FSREvent;
import com.oracle.e1.aisclient.FormRequest;
import com.oracle.e1.aisclient.JDERestServiceException;
import com.oracle.e1.aisclient.JDERestServiceProvider;
import com.oracle.e1.aisclient.LoginEnvironment;
import java.io.IOException;

/**
 * @author mtamassia Created on May 8, 2015 6:30:32 PM
 */
public class Main {

    public static void main(String[] args) {
        // Perform call
        P01012_W01012B_FormParent aBook = getAddressBookForm("JDE");

        Logger.l("Processing data retrieved");
        Logger.l(" Application Title: " + aBook.getFs_P01012_W01012B().getTitle());
        Logger.l(" Retrieving " + aBook.getFs_P01012_W01012B().getData().getGridData().getRowset().size() + " grid rows");
        for (P01012_W01012B_GridRow gr : aBook.getFs_P01012_W01012B().getData().getGridData().getRowset()) {
            Logger.l("   Row: " + gr.getRowIndex() + ", Address Book:" + gr.getMnAddressNumber_19().getValue() + ", Name:" + gr.getSAlphaName_20().getValue());
        }
    }

    public static P01012_W01012B_FormParent getAddressBookForm(String e1User) {
        LoginEnvironment lEnv = Login.getLoginAIS(e1User);

        P01012_W01012B_FormParent addressBook = null;

        try {
            // Perform Logout
            Logger.l("Opening Address Book application with user " + e1User);

            FormRequest formRequest = new FormRequest(lEnv);
            formRequest.setFormName("P01012_W01012B");
            formRequest.setFormServiceAction("R");
            formRequest.setMaxPageSize("5"); //only get 5 records
            formRequest.setReturnControlIDs("54|1[19,20]");

            FSREvent fsrEvent = new FSREvent();
            fsrEvent.setFieldValue("54", "E"); //customers
            fsrEvent.setQBEValue("1[19]", ">=" + "4800"); // Address Book Record to filter
            fsrEvent.checkBoxChecked("62"); //show address
            fsrEvent.checkBoxChecked("63"); //show phone
            fsrEvent.doControlAction("15"); //find

            formRequest.addFSREvent(fsrEvent); //add the events to the request
            String response = JDERestServiceProvider.jdeRestServiceCall(lEnv, formRequest, JDERestServiceProvider.POST_METHOD, JDERestServiceProvider.FORM_SERVICE_URI);

            //de-serialize the JSON string into the form parent object
            addressBook = lEnv.getObjectMapper().readValue(response, P01012_W01012B_FormParent.class);
        } catch (JDERestServiceException e) {
            Logger.l(JDERestServiceProvider.handleServiceException(e));
        } catch (IOException e) {
            Logger.l(e);
        }

        // Perform Logout
        Logger.l("Logging out user " + e1User);
        AISClientUtilities.logout(lEnv);

        return addressBook;
    }

}
