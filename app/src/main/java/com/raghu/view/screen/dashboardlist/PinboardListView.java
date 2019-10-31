package com.raghu.view.screen.dashboardlist;

import com.raghu.model.Master_Details;
import com.raghu.view.screen.common.CommonView;

import java.util.ArrayList;

/**
 * This interface is used for pinboard activities.
 *
 * @author SandeepD
 * @version 1.0
 */
interface PinboardListView extends CommonView
{

    void renderUserList(ArrayList<Master_Details> users);
}
