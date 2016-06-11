package inphamouswin.mathkills;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class BackgroundMusicService extends Service {

    MediaPlayer player;
    private int length = 0;

    public BackgroundMusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // References the Alan Walker's Faded BGM file
        player = MediaPlayer.create(this, R.raw.faded_alan_walker);
        // Loops the music
        player.setLooping(true);
        // Sets the volume
        player.setVolume(100, 100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Starts the BGM music player
        player.start();
        // Recreates service if OS destroys it
        return START_STICKY;
    }

    public void pauseMusic(){
        // Pauses BGM music player if it is currently playing
        if(player.isPlaying()){
            player.pause();
            // References the position of the BGM when paused
            length = player.getCurrentPosition();
        }
    }

    public void resumeMusic(){
        // Starts BGM music player if it is not playing
        if(player.isPlaying() == false){
            // Resumes BGM at the position when paused
            player.seekTo(length);
            player.start();
        }
    }

    public void stopMusic(){
        // Stops BGM music player
        player.stop();
        // Releases resources attached to BGM music player
        player.release();
        // Nullifies BGM music player
        player = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(player != null){
            // Stops and releases the BGM music player
            try{
                player.stop();
                player.release();
            }
            // If there is an error in "try", the function will skip
            // to "finally" and nullify the BGM music player
            finally {
                player = null;
            }
        }
    }
}
