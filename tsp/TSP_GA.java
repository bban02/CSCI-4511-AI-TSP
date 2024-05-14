/*
* TSP_GA.java
* Create a tour and evolve a solution
*/

package tsp;

public class TSP_GA {

    public static void main(String[] args) {
        double startTime = System.nanoTime();
        City cities[] = new City[19];
        City current;
        // Create and add our cities
        City albertvilleMN = new City("albertvilleMN", 45.2380, -93.6586);
        TourManager.addCity(albertvilleMN);
        current = albertvilleMN;
        City durhamNC = new City("durhamNC", 35.9940, -78.8986);
        TourManager.addCity(durhamNC);
        cities[0] = durhamNC;
        City phoenixAZ = new City("phoenixAZ", 33.4484, -112.0740);
        TourManager.addCity(phoenixAZ);
        cities[1] = phoenixAZ;
        City stCloudMN = new City("stCloudMN", 45.5579, -94.1632);
        TourManager.addCity(stCloudMN);
        cities[2] = stCloudMN;
        City underwoodMN = new City("underwoodMN", 46.3130, -95.8054);
        TourManager.addCity(underwoodMN);
        cities[3] = underwoodMN;
        City wisconsinDellsWI = new City("wisconsinDellsWI", 43.6275, -89.771);
        TourManager.addCity(wisconsinDellsWI);
        cities[4] = wisconsinDellsWI;
        City austinTX = new City("austinTX", 30.2672, -97.7431);
        TourManager.addCity(austinTX);
        cities[5] = austinTX;
        City sanDiegoCA = new City("sanDiegoCA", 32.7157, -117.1611);
        TourManager.addCity(sanDiegoCA);
        cities[6] = sanDiegoCA;
        City portlandOR = new City("portlandOR", 45.5152, -122.6784);
        TourManager.addCity(portlandOR);
        cities[7] = portlandOR;
        City oakCreekWI = new City("oakCreekWI", 42.8859, -87.8631);
        TourManager.addCity(oakCreekWI);
        cities[8] = oakCreekWI;
        City kansasCityKS = new City("kansasCityKS", 39.0997, -94.5786);
        TourManager.addCity(kansasCityKS);
        cities[9] = kansasCityKS;
        City lasVegasNV = new City("lasVegasNV", 36.1716, -115.1391);
        TourManager.addCity(lasVegasNV);
        cities[10] = lasVegasNV;
        City denverCO = new City("denverCO", 39.7392, -104.9903);
        TourManager.addCity(denverCO);
        cities[11] = denverCO;
        City orlandoFL = new City("orlandoFL", 28.5384, -81.3789);
        TourManager.addCity(orlandoFL);
        cities[12] = orlandoFL;
        City philadelphiaPA = new City("philadelphiaPA", 39.9526, -75.1652);
        TourManager.addCity(philadelphiaPA);
        cities[13] = philadelphiaPA;
        City nashvilleTN = new City("nashvilleTN", 36.1627, -86.7816);
        TourManager.addCity(nashvilleTN);
        cities[14] = nashvilleTN;
        City indianapolisIN = new City("indianapolisIN", 39.7684, -86.1581);
        TourManager.addCity(indianapolisIN);
        cities[15] = indianapolisIN;
        City buffaloNY = new City("buffaloNY", 42.8864, -78.8784);
        TourManager.addCity(buffaloNY);
        cities[16] = buffaloNY;
        City detroitMI = new City("detroitMI", 42.3314, -83.0458);
        TourManager.addCity(detroitMI);
        cities[17] = detroitMI;
        City louisvilleKY = new City("louisvilleKY", 38.2527, -85.7585);
        TourManager.addCity(louisvilleKY);
        cities[18] = louisvilleKY;

        // Initialize population
        Population pop = new Population(500, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 1000; i++) {
            pop = GA.evolvePopulation(pop);
        }
        double elapsedTime = (System.nanoTime() - startTime) / 1000000000.0;
        elapsedTime *= 1000.0;

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
        System.out.println("RunTime: " + elapsedTime + " ms");

        double neighborTime = System.nanoTime();
        double totalDist = 0;
        String geneString = "| ";
        geneString += current.cityName+" | ";
        while (cities.length > 0) {
            double min = 1000000;
            int index = 0;
            for (int i = 0; i < cities.length; i++) {
                if (current.distanceTo(cities[i]) < min) {
                    index = i;
                    min = current.distanceTo(cities[i]);
                }
            }
            current = cities[index];
            totalDist += min;
            City newArray[] = new City[cities.length - 1];
            int k = 0;
            for (int i = 0; i < cities.length; i++) {
                if(i == index) {
                    continue;
                }
                newArray[k++] = cities[i];
            }
            cities = newArray;
            geneString += current.cityName+" | ";
        }
        double nElapsedTime = (System.nanoTime() - neighborTime) / 1000000000.0;
        nElapsedTime *= 1000.0;
        totalDist += albertvilleMN.distanceTo(current);
        geneString += albertvilleMN.cityName + " |";
        // System.out.println("Total Distance using closest neighbor algorithm:");
        // System.out.println(totalDist);
        // System.out.println(geneString);
        // System.out.println("RunTime: " + nElapsedTime + " ms");
    }
}