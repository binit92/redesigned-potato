import java.io.File;

public class MapReader {

    private final String mapPath;
    private static final String TAG = MapReader.class.getSimpleName();

    public static void main(String [] args){
        System.out.println(" Test");

        // hard-coded path
        String path = "D:\\redesigned-potato\\maps\\canada";
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

            Util.log(TAG, "start processing map file at: " + mapFile.getAbsolutePath() );

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
