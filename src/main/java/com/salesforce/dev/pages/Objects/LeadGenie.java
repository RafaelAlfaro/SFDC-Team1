package com.salesforce.dev.pages.Objects;

import com.salesforce.dev.framework.APIConnector;
import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.sobject.SObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ariel Mattos on 07/09/2015.
 */
public class LeadGenie {
    public static ViewSalesForce getLeadsView(String jsonFile) {
        PartnerConnection connection = APIConnector.getInstance().getConnection();
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        Iterator<ViewSalesForce[]> iteratorViewData = dataDrivenManager.getDataView(jsonFile);
        List<ViewSalesForce[]> listData = new ArrayList<ViewSalesForce[]>();
        while (iteratorViewData.hasNext()) {
            listData.add(iteratorViewData.next());
        }
        ViewSalesForce viewSalesForce = listData.get(0)[0];
        SObject account = new SObject();
        return viewSalesForce;
    }
}
