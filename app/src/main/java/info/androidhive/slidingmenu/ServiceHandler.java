package info.androidhive.slidingmenu;

/**
 * Created by UNKNOWN on 6/8/2016.
 */
public class ServiceHandler {

    static  String response = null;
    public final static int GET = 1;
    public final static int POST = 2;

    public ServiceHandler(){

    }

    public String makeServiceCall(String url, int method, Object o){
        return  this.makeServiceCall(url,method,null);
    }

}
