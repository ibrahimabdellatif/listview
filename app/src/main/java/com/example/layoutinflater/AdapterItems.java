package com.example.layoutinflater;
//this class for pass data to showinflater layout.
public class AdapterItems {
    public int ID;
    public String JobTitle;
    public String Description;
    //for news details
    AdapterItems( int ID , String JobTitle , String Description){
        this.ID=ID;
        this.JobTitle = JobTitle;
        this.Description=Description;
    }
}
