import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MapReader implements IMapConstants {

    private final String mapPath;
    private static final String TAG = MapReader.class.getSimpleName();

    public static void main(String [] args){
        System.out.println(" Test");

        // hard-coded path
        String path = "D:\\redesigned-potato\\maps\\canada\\canada.map";
        MapReader mp = new MapReader(path);
        mp.process();
    }

    public MapReader(String mapPath){
        this.mapPath = mapPath;
    }

    private void process(){
        try{
            File mapFile = new File(mapPath);
            if(!mapFile.exists()){
                Util.log(TAG, "map file is not available at: " + mapFile );
                return;
            }
            readMapFile(mapFile);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  method to read map file
     * @param mapFile : absolute path of the map file
     * @throws Exception : throws error
     */

    private void readMapFile(File mapFile) throws Exception{
        Util.log(TAG, "reading map file from: " + mapFile.getAbsolutePath() );
        FileReader fr = new FileReader(mapFile);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null){
            Util.logDebug(TAG,"line: " + line);
            if (line.equalsIgnoreCase(HEADER_CONTINENT)){

                // Read continents in next line if it is not null or empty ..
                // TODO : recheck this, is checking "" is better ?
                while((line = br.readLine()).length() >0){
                    Util.log(TAG, "continent : " + line);
                }
                /* note: it will automatically come out of this loop as there is a blank
                    line between continent list and countries list in domination maps
                */
            }else if (line.equalsIgnoreCase(HEADER_COUNTRIES)){

                // Read countries list in the .map file
                while((line = br.readLine()).length() >0){
                    Util.log(TAG, "country : " + line);
                }
            }
        }
    }

}
