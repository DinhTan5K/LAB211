package Week8.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManageEastAsiaCountries {


    private EastAsiaCountries[] countries = new EastAsiaCountries[11];
    private int i = -1;
    public List<Exception> addCountry(EastAsiaCountries country) throws Exception {
        List<Exception> exceptions = new ArrayList<>();

        try {
            if (country.getCountryCode().isEmpty()) {
                exceptions.add(new Exception("Country code cannot be empty."));
            }

            if (country.getCountryName().isEmpty()) {
                exceptions.add(new Exception("Country name cannot be empty."));
            }

            if (country.getTotalArea() <= 0) {
                exceptions.add(new Exception("Total area must be greater than 0."));
            }

            if (country.getCountryTerrain().isEmpty()) {
                exceptions.add(new Exception("Terrain cannot be empty."));
            }
            if(exceptions.isEmpty()){
                countries[++i] = country;
            }


        } catch (Exception e) {
            exceptions.add(e);
        }
        return exceptions;

    }



    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {

        if ( i < 0) {
            return null;
        } else {

            return countries[i];

        }
    }

    public EastAsiaCountries[] searchInformationByName(String name) throws Exception{

        int count = 0;
        for (int j = 0; j <= i; j++) {
            if (countries[j] != null && countries[j].getCountryName().equals(name)) {
                count++;
            }
        }

        if (count == 0) {
            return null;
        }

        EastAsiaCountries[] eacs = new EastAsiaCountries[count];
        int index = 0;

        for (int j = 0; j <= i; j++) {
            if (countries[j] != null && countries[j].getCountryName().equals(name)) {
                eacs[index++] = countries[j];
            }
        }

        return eacs;
    }

    public List<EastAsiaCountries> sortInformationByAscendingOrder() {

        List<EastAsiaCountries> countryList = new ArrayList<>();
        for (int j = 0; j <= i; j++) {
            if (countries[j] != null) {
                countryList.add(countries[j]);
            }
        }


        Collections.sort(countryList, (c1, c2) -> c1.getCountryName().compareTo(c2.getCountryName()));

        return countryList;
    }


}