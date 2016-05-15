package com.home.ubbs.foto.diary.session;

/**
 * Created by udyatbhanu-mac on 5/14/16.
 */
public class AppSession {
    public static int selectedItem;
    private AppSession(){}

    public static int getSelectedItem() {
        return selectedItem;
    }

    public static void setSelectedItem(int selectedItem) {
        AppSession.selectedItem = selectedItem;
    }




}
