package com.raghu.view.screen.details;

import com.raghu.model.Master_Details;
import com.raghu.model.All_User_Details;

/**
 * This interface is used for pin detail view activities.
 *
 * @author SandeepD
 * @version 1.0
 */
interface PinDetailsView
{

    void renderPhoto(String full);

    void setBackgroundColor(String color);

    void renderUserDetails(All_User_Details user);

    void renderPhotoDetails(Master_Details currentData);

    void renderCategories(String displayCategories);
}
