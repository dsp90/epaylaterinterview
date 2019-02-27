package com.pawardushyant.epaylaterinterview.retrofit.constants;

import com.pawardushyant.epaylaterinterview.MainApp;

public class Constants {

    public final static String BASE_URL = "https://interviewer-api.herokuapp.com";
    public final static String CONTENT_TYPE = "application/json";
    public final static String AUTHTOKEN = "Bearer " + MainApp.getPrefs().getAccountToken();

    public interface Endpoint {
        public static final String login = BASE_URL + "/login";
        public static final String balance = BASE_URL + "/balance";
        public static final String transactions = BASE_URL + "/transactions";
        public static final String spend = BASE_URL + "/spend";
    }
}
