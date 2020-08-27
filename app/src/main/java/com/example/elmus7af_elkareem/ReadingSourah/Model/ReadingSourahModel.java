package com.example.elmus7af_elkareem.ReadingSourah.Model;

import androidx.drawerlayout.widget.DrawerLayout;


public class ReadingSourahModel {

    private static DrawerLayout drawer;





    public static DrawerLayout getDrawer() {
        return drawer;
    }




    public ReadingSourahModel(DrawerLayout drawer) {
        this.drawer = drawer;
    }



}
