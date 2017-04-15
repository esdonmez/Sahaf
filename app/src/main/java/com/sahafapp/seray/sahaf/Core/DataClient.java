package com.sahafapp.seray.sahaf.Core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sahafapp.seray.sahaf.Models.AddAdvertModel;
import com.sahafapp.seray.sahaf.Models.AdvertModel;
import com.sahafapp.seray.sahaf.Models.CategoryModel;
import com.sahafapp.seray.sahaf.Models.PersonModel;
import com.sahafapp.seray.sahaf.Models.ReportPersonModel;
import com.sahafapp.seray.sahaf.Models.ReqAdvertModel;
import com.sahafapp.seray.sahaf.Models.ResultModel;
import com.sahafapp.seray.sahaf.Models.TokenModel;
import com.sahafapp.seray.sahaf.Models.UserModel;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import java.util.List;

public class DataClient
{
    private HttpClient Client = new HttpClient();
    public String ApiUrl = "http://146.185.147.162:8000";
    private Gson jsonConverter = new Gson();


    public DataClient(){
    }


    public void SetToken(String token){
        Client.Token = token;
    }

    public TokenModel FacebookLogin(String accessToken){
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("token", accessToken));

        String result = Client.CreatePOSTRequest(ApiUrl + "/users/facebook", params);
        return jsonConverter.fromJson(result, new TypeToken<TokenModel>(){}.getType());
    }

    public UserModel GetMe(){
        String result = Client.CreateGETRequest(ApiUrl + "/users/me/");
        return jsonConverter.fromJson(result, new TypeToken<UserModel>(){}.getType());
    }

    public List<AdvertModel> GetAdverts() {
        String result = Client.CreateGETRequest(ApiUrl + "/adverts/");
        return jsonConverter.fromJson(result, new TypeToken<List<AdvertModel>>(){}.getType());
    }

    public List<CategoryModel> Categories() {
        String result = Client.CreateGETRequest(ApiUrl + "/books/categories/");
        return jsonConverter.fromJson(result, new TypeToken<List<CategoryModel>>(){}.getType());
    }

    public List<AdvertModel> GetNearestAdverts(ReqAdvertModel model) {
        String result = Client.CreateGETRequest("/adverts/search/city/?City=" + model.City + "&Latitude=" + model.Latitude + "&Longitude=" + model.Longitude);
        return jsonConverter.fromJson(result, new TypeToken<List<AdvertModel>>(){}.getType());
    }

    public List<AdvertModel> GetAdvertsFindById(int personId) {
        String result = Client.CreateGETRequest("/users/" + personId + "/adverts/");
        return jsonConverter.fromJson(result, new TypeToken<List<AdvertModel>>(){}.getType());
    }

    public List<ResultModel> AddAdvert(AddAdvertModel model) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("AdvertDate", model.AdvertDate));
        params.add(new BasicNameValuePair("Name", model.Name));
        params.add(new BasicNameValuePair("Image", model.Image));
        params.add(new BasicNameValuePair("Category", model.Category));
        params.add(new BasicNameValuePair("City", model.City));
        params.add(new BasicNameValuePair("Description", model.Description));
        params.add(new BasicNameValuePair("Latitude", model.Latitude));
        params.add(new BasicNameValuePair("Longitude", model.Longitude));
        params.add(new BasicNameValuePair("Price", model.Price));

        String result = Client.CreatePOSTRequest("/adverts/", params);
        return jsonConverter.fromJson(result, new TypeToken<List<ResultModel>>(){}.getType());
    }

    public List<ResultModel> AdvertBuy(int advertId) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("AdvertId", Integer.toString(advertId)));
        String result = Client.CreatePOSTRequest("/adverts/request/", params);
        return jsonConverter.fromJson(result, new TypeToken<List<ResultModel>>(){}.getType());
    }

    public List<ResultModel> AdvertSold(int advertId) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("AdvertId", Integer.toString(advertId)));
        String result = Client.CreatePOSTRequest("/adverts/sold/", params);
        return jsonConverter.fromJson(result, new TypeToken<List<ResultModel>>(){}.getType());
    }

    public List<ResultModel> AdvertDelete(int advertId) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("AdvertId", Integer.toString(advertId)));
        String result = Client.CreatePOSTRequest("/adverts/delete/", params);
        return jsonConverter.fromJson(result, new TypeToken<List<ResultModel>>(){}.getType());
    }

    public List<AdvertModel> FindAdvert(int keyword) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Keyword", Integer.toString(keyword)));
        String result = Client.CreatePOSTRequest("/api/advert/find", params);
        return jsonConverter.fromJson(result, new TypeToken<List<AdvertModel>>(){}.getType());
    }

    public List<PersonModel> GetPersonInformation(int personId) {
        String result = Client.CreateGETRequest("/users/" + personId);
        return jsonConverter.fromJson(result, new TypeToken<List<PersonModel>>(){}.getType());
    }

    public List<ResultModel> ReportPerson(ReportPersonModel model) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Description", model.Description));
        params.add(new BasicNameValuePair("ReportedUserId_id", Integer.toString(model.ReportedUserId_id)));
        String result = Client.CreatePOSTRequest("/report/user/", params);
        return jsonConverter.fromJson(result, new TypeToken<List<ResultModel>>(){}.getType());
    }

    /*public List<TokenModel> ImageUpload(byte[] array) throws IOException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        ByteArrayEntity imageForm = new ByteArrayEntity(array, 0, array.length);
        imageForm.setContentType("image/jpg");
        ContentBody cb = new ByteArrayBody(array, "testImage.jpg");
        builder.addPart("Image" , cb);

        String result = Client.CreatePOSTRequest("/users/image/", builder);
        return jsonConverter.fromJson(result, new TypeToken<List<TokenModel>>(){}.getType());
    }*/
}
