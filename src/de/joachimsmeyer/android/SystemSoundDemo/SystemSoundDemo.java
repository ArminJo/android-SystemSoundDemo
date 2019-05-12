package de.joachimsmeyer.android.SystemSoundDemo;

/*
 * Plays tones from android.media.ToneGenerator
 * Description of sound are from android.media.ToneGenerator.class
 */

import android.app.ListActivity;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SystemSoundDemo extends ListActivity {

	static String[] ToneInfo = {
			"  0    DTMF tone for key 0: 1336Hz, 941Hz, continuous",
			"  1    DTMF tone for key 1: 1209Hz, 697Hz, continuous",
			"  2    DTMF tone for key 2: 1336Hz, 697Hz, continuous",
			"  3    DTMF tone for key 3: 1477Hz, 697Hz, continuous",
			"  4    DTMF tone for key 4: 1209Hz, 770Hz, continuous",
			"  5    DTMF tone for key 5: 1336Hz, 770Hz, continuous",
			"  6    DTMF tone for key 6: 1477Hz, 770Hz, continuous",
			"  7    DTMF tone for key 7: 1209Hz, 852Hz, continuous",
			"  8    DTMF tone for key 8: 1336Hz, 852Hz, continuous",
			"  9    DTMF tone for key 9: 1477Hz, 852Hz, continuous",
			" 10    DTMF tone for key *: 1209Hz, 941Hz, continuous",
			" 11    DTMF tone for key #: 1477Hz, 941Hz, continuous",
			" 12    DTMF tone for key A: 1633Hz, 697Hz, continuous",
			" 13    DTMF tone for key B: 1633Hz, 770Hz, continuous",
			" 14    DTMF tone for key C: 1633Hz, 852Hz, continuous",
			" 15    DTMF tone for key D: 1633Hz, 941Hz, continuous",
			" 16    Call supervisory tone, Dial tone: CEPT: 425Hz, continuous ANSI (IS-95): 350Hz+440Hz, continuous JAPAN: 400Hz, continuous",
			" 17    Call supervisory tone, Busy: CEPT: 425Hz, 500ms ON, 500ms OFF... ANSI (IS-95): 480Hz+620Hz, 500ms ON, 500ms OFF... JAPAN: 400Hz, 500ms ON, 500ms OFF...",
			" 18    Call supervisory tone, Congestion: CEPT, JAPAN: 425Hz, 200ms ON, 200ms OFF... ANSI (IS-95): 480Hz+620Hz, 250ms ON, 250ms OFF...",
			" 19    Call supervisory tone, Radio path acknowlegment : CEPT, ANSI: 425Hz, 200ms ON JAPAN: 400Hz, 1s ON, 2s OFF...",
			" 20    Call supervisory tone, Radio path not available: 425Hz, 200ms ON, 200 OFF 3 bursts",
			" 21    Call supervisory tone, Error/Special info: 950Hz+1400Hz+1800Hz, 330ms ON, 1s OFF...",
			" 22    Call supervisory tone, Call Waiting: CEPT, JAPAN: 425Hz, 200ms ON, 600ms OFF, 200ms ON, 3s OFF... ANSI (IS-95): 440 Hz, 300 ms ON, 9.7 s OFF, (100 ms ON, 100 ms OFF, 100 ms ON, 9.7s OFF ...)",
			" 23    Call supervisory tone, Ring Tone: CEPT, JAPAN: 425Hz, 1s ON, 4s OFF... ANSI (IS-95): 440Hz + 480Hz, 2s ON, 4s OFF...",
			" 24    Proprietary tone, general beep: 400Hz+1200Hz, 35ms ON",
			" 25    Proprietary tone, positive acknowlegement: 1200Hz, 100ms ON, 100ms OFF 2 bursts",
			" 26    Proprietary tone, negative acknowlegement: 300Hz+400Hz+500Hz, 400ms ON",
			" 27    Proprietary tone, prompt tone: 400Hz+1200Hz, 200ms ON",
			" 28    Proprietary tone, general double beep: twice 400Hz+1200Hz, 35ms ON, 200ms OFF, 35ms ON",
			" 29    Call supervisory tone (IS-95), intercept tone: alternating 440 Hz and 620 Hz tones, each on for 250 ms",
			" 30    Call supervisory tone (IS-95), abbreviated intercept: intercept tone limited to 4 seconds",
			" 31    Call supervisory tone (IS-95), abbreviated congestion: congestion tone limited to 4 seconds",
			" 32    Call supervisory tone (IS-95), confirm tone: a 350 Hz tone added to a 440 Hz tone repeated 3 times in a 100 ms on, 100 ms off cycle",
			" 33    Call supervisory tone (IS-95), pip tone: four bursts of 480 Hz tone (0.1 s on, 0.1 s off).",
			" 34    CDMA Dial tone : 425Hz continuous",
			" 35    CDMA USA Ringback: 440Hz+480Hz 2s ON, 4000 OFF ...",
			" 36    CDMA Intercept tone: 440Hz 250ms ON, 620Hz 250ms ON ...",
			" 37    CDMA Abbr Intercept tone: 440Hz 250ms ON, 620Hz 250ms ON",
			" 38    CDMA Reorder tone: 480Hz+620Hz 250ms ON, 250ms OFF...",
			" 39    CDMA Abbr Reorder tone: 480Hz+620Hz 250ms ON, 250ms OFF repeated for 8 times",
			" 40    CDMA Network Busy tone: 480Hz+620Hz 500ms ON, 500ms OFF continuous",
			" 41    CDMA Confirm tone: 350Hz+440Hz 100ms ON, 100ms OFF repeated for 3 times",
			" 42    CDMA answer tone: silent tone - defintion Frequency 0, 0ms ON, 0ms OFF",
			" 43    CDMA Network Callwaiting tone: 440Hz 300ms ON",
			" 44    CDMA PIP tone: 480Hz 100ms ON, 100ms OFF repeated for 4 times",
			" 45    ISDN Call Signal Normal tone: {2091Hz 32ms ON, 2556 64ms ON} 20 times, 2091 32ms ON, 2556 48ms ON, 4s OFF",
			" 46    ISDN Call Signal Intergroup tone: {2091Hz 32ms ON, 2556 64ms ON} 8 times, 2091Hz 32ms ON, 400ms OFF, {2091Hz 32ms ON, 2556Hz 64ms ON} times, 2091Hz 32ms ON, 4s OFF.",
			" 47    ISDN Call Signal SP PRI tone:{2091Hz 32ms ON, 2556 64ms ON} 4 times 2091Hz 16ms ON, 200ms OFF, {2091Hz 32ms ON, 2556Hz 64ms ON} 4 times, 2091Hz 16ms ON, 200ms OFF",
			" 48    ISDN Call sign PAT3 tone: silent tone",
			" 49    ISDN Ping Ring tone: {2091Hz 32ms ON, 2556Hz 64ms ON} 5 times 2091Hz 20ms ON",
			" 50    ISDN Pat5 tone: silent tone",
			" 51    ISDN Pat6 tone: silent tone",
			" 52    ISDN Pat7 tone: silent tone",
			" 53    TONE_CDMA_HIGH_L tone: {3700Hz 25ms, 4000Hz 25ms} 40 times 4000ms OFF, Repeat ....",
			" 54    TONE_CDMA_MED_L tone: {2600Hz 25ms, 2900Hz 25ms} 40 times 4000ms OFF, Repeat ....",
			" 55    TONE_CDMA_LOW_L tone: {1300Hz 25ms, 1450Hz 25ms} 40 times, 4000ms OFF, Repeat ....",
			" 56    CDMA HIGH SS tone: {3700Hz 25ms, 4000Hz 25ms} repeat 16 times, 400ms OFF, repeat ....",
			" 57    CDMA MED SS tone: {2600Hz 25ms, 2900Hz 25ms} repeat 16 times, 400ms OFF, repeat ....",
			" 58    CDMA LOW SS tone: {1300z 25ms, 1450Hz 25ms} repeat 16 times, 400ms OFF, repeat ....",
			" 59    CDMA HIGH SSL tone: {3700Hz 25ms, 4000Hz 25ms} 8 times, 200ms OFF, {3700Hz 25ms, 4000Hz 25ms} repeat 8 times, 200ms OFF, {3700Hz 25ms, 4000Hz 25ms} repeat 16 times, 4000ms OFF, repeat ...",
			" 60    CDMA MED SSL tone: {2600Hz 25ms, 2900Hz 25ms} 8 times, 200ms OFF, {2600Hz 25ms, 2900Hz 25ms} repeat 8 times, 200ms OFF, {2600Hz 25ms, 2900Hz 25ms} repeat 16 times, 4000ms OFF, repeat ...",
			" 61    CDMA LOW SSL tone: {1300Hz 25ms, 1450Hz 25ms} 8 times, 200ms OFF, {1300Hz 25ms, 1450Hz 25ms} repeat 8 times, 200ms OFF, {1300Hz 25ms, 1450Hz 25ms} repeat 16 times, 4000ms OFF, repeat ...",
			" 62    CDMA HIGH SS2 tone: {3700Hz 25ms, 4000Hz 25ms} 20 times, 1000ms OFF, {3700Hz 25ms, 4000Hz 25ms} 20 times, 3000ms OFF, repeat ....",
			" 63    CDMA MED SS2 tone: {2600Hz 25ms, 2900Hz 25ms} 20 times, 1000ms OFF, {2600Hz 25ms, 2900Hz 25ms} 20 times, 3000ms OFF, repeat ....",
			" 64    CDMA LOW SS2 tone: {1300Hz 25ms, 1450Hz 25ms} 20 times, 1000ms OFF, {1300Hz 25ms, 1450Hz 25ms} 20 times, 3000ms OFF, repeat ....",
			" 65    CDMA HIGH SLS tone: {3700Hz 25ms, 4000Hz 25ms} 10 times, 500ms OFF, {3700Hz 25ms, 4000Hz 25ms} 20 times, 500ms OFF, {3700Hz 25ms, 4000Hz 25ms} 10 times, 3000ms OFF, REPEAT",
			" 66    CDMA MED SLS tone: {2600Hz 25ms, 2900Hz 25ms} 10 times, 500ms OFF, {2600Hz 25ms, 2900Hz 25ms} 20 times, 500ms OFF, {2600Hz 25ms, 2900Hz 25ms} 10 times, 3000ms OFF, REPEAT",
			" 67    CDMA LOW SLS tone: {1300Hz 25ms, 1450Hz 25ms} 10 times, 500ms OFF, {1300Hz 25ms, 1450Hz 25ms} 20 times, 500ms OFF, {1300Hz 25ms, 1450Hz 25ms} 10 times, 3000ms OFF, REPEAT",
			" 68    CDMA HIGH S X4 tone: {3700Hz 25ms, 4000Hz 25ms} 10 times, 500ms OFF, {3700Hz 25ms, 4000Hz 25ms} 10 times, 500ms OFF, {3700Hz 25ms, 4000Hz 25ms} 10 times, 500ms OFF, {3700Hz 25ms, 4000Hz 25ms} 10 times, 2500ms OFF, REPEAT....",
			" 69    CDMA MED S X4 tone: {2600Hz 25ms, 2900Hz 25ms} 10 times, 500ms OFF, {2600Hz 25ms, 2900Hz 25ms} 10 times, 500ms OFF, {2600Hz 25ms, 2900Hz 25ms} 10 times, 500ms OFF, {2600Hz 25ms, 2900Hz 25ms} 10 times, 2500ms OFF, REPEAT....",
			" 70    CDMA LOW S X4 tone: {2600Hz 25ms, 2900Hz 25ms} 10 times, 500ms OFF, {2600Hz 25ms, 2900Hz 25ms} 10 times, 500ms OFF, {2600Hz 25ms, 2900Hz 25ms} 10 times, 500ms OFF, {2600Hz 25ms, 2900Hz 25ms} 10 times, 2500ms OFF, REPEAT....",
			" 71    CDMA HIGH PBX L: {3700Hz 25ms, 4000Hz 25ms}20 times, 2000ms OFF, REPEAT....",
			" 72    CDMA MED PBX L: {2600Hz 25ms, 2900Hz 25ms}20 times, 2000ms OFF, REPEAT....",
			" 73    CDMA LOW PBX L: {1300Hz 25ms,1450Hz 25ms}20 times, 2000ms OFF, REPEAT....",
			" 74    CDMA HIGH PBX SS tone: {3700Hz 25ms, 4000Hz 25ms} 8 times 200 ms OFF, {3700Hz 25ms 4000Hz 25ms}8 times, 2000ms OFF, REPEAT....",
			" 75    CDMA MED PBX SS tone: {2600Hz 25ms, 2900Hz 25ms} 8 times 200 ms OFF, {2600Hz 25ms 2900Hz 25ms}8 times, 2000ms OFF, REPEAT....",
			" 76    CDMA LOW PBX SS tone: {1300Hz 25ms, 1450Hz 25ms} 8 times 200 ms OFF, {1300Hz 25ms 1450Hz 25ms}8 times, 2000ms OFF, REPEAT....",
			" 77    CDMA HIGH PBX SSL tone:{3700Hz 25ms, 4000Hz 25ms} 8 times 200ms OFF, {3700Hz 25ms, 4000Hz 25ms} 8 times, 200ms OFF, {3700Hz 25ms, 4000Hz 25ms} 16 times, 1000ms OFF, REPEAT....",
			" 78    CDMA MED PBX SSL tone:{2600Hz 25ms, 2900Hz 25ms} 8 times 200ms OFF, {2600Hz 25ms, 2900Hz 25ms} 8 times, 200ms OFF, {2600Hz 25ms, 2900Hz 25ms} 16 times, 1000ms OFF, REPEAT....",
			" 79    CDMA LOW PBX SSL tone:{1300Hz 25ms, 1450Hz 25ms} 8 times 200ms OFF, {1300Hz 25ms, 1450Hz 25ms} 8 times, 200ms OFF, {1300Hz 25ms, 1450Hz 25ms} 16 times, 1000ms OFF, REPEAT....",
			" 80    CDMA HIGH PBX SSL tone:{3700Hz 25ms, 4000Hz 25ms} 8 times 200ms OFF, {3700Hz 25ms, 4000Hz 25ms} 16 times, 200ms OFF, {3700Hz 25ms, 4000Hz 25ms} 8 times, 1000ms OFF, REPEAT....",
			" 81    CDMA HIGH PBX SLS tone:{2600Hz 25ms, 2900Hz 25ms} 8 times 200ms OFF, {2600Hz 25ms, 2900Hz 25ms} 16 times, 200ms OFF, {2600Hz 25ms, 2900Hz 25ms} 8 times, 1000ms OFF, REPEAT....",
			" 82    CDMA HIGH PBX SLS tone:{1300Hz 25ms, 1450Hz 25ms} 8 times 200ms OFF, {1300Hz 25ms, 1450Hz 25ms} 16 times, 200ms OFF, {1300Hz 25ms, 1450Hz 25ms} 8 times, 1000ms OFF, REPEAT....",
			" 83    CDMA HIGH PBX X S4 tone: {3700Hz 25ms 4000Hz 25ms} 8 times, 200ms OFF, {3700Hz 25ms 4000Hz 25ms} 8 times, 200ms OFF, {3700Hz 25ms 4000Hz 25ms} 8 times, 200ms OFF, {3700Hz 25ms 4000Hz 25ms} 8 times, 800ms OFF, REPEAT...",
			" 84    CDMA MED PBX X S4 tone: {2600Hz 25ms 2900Hz 25ms} 8 times, 200ms OFF, {2600Hz 25ms 2900Hz 25ms} 8 times, 200ms OFF, {2600Hz 25ms 2900Hz 25ms} 8 times, 200ms OFF, {2600Hz 25ms 2900Hz 25ms} 8 times, 800ms OFF, REPEAT...",
			" 85    CDMA LOW PBX X S4 tone: {1300Hz 25ms 1450Hz 25ms} 8 times, 200ms OFF, {1300Hz 25ms 1450Hz 25ms} 8 times, 200ms OFF, {1300Hz 25ms 1450Hz 25ms} 8 times, 200ms OFF, {1300Hz 25ms 1450Hz 25ms} 8 times, 800ms OFF, REPEAT...",
			" 86    CDMA Alert Network Lite tone: 1109Hz 62ms ON, 784Hz 62ms ON, 740Hz 62ms ON 622Hz 62ms ON, 1109Hz 62ms ON",
			" 87    CDMA Alert Auto Redial tone: {1245Hz 62ms ON, 659Hz 62ms ON} 3 times, 1245 62ms ON",
			" 88    CDMA One Min Beep tone: 1150Hz+770Hz 400ms ON",
			" 89    CDMA KEYPAD Volume key lite tone: 941Hz+1477Hz 120ms ON",
			" 90    CDMA PRESSHOLDKEY LITE tone: 587Hz 375ms ON, 1175Hz 125ms ON",
			" 91    CDMA ALERT INCALL LITE tone: 587Hz 62ms, 784 62ms, 831Hz 62ms, 784Hz 62ms, 1109 62ms, 784Hz 62ms, 831Hz 62ms, 784Hz 62ms",
			" 92    CDMA EMERGENCY RINGBACK tone: {941Hz 125ms ON, 10ms OFF} 3times 4990ms OFF, REPEAT...",
			" 93    CDMA ALERT CALL GUARD tone: {1319Hz 125ms ON, 125ms OFF} 3 times",
			" 94    CDMA SOFT ERROR LITE tone: 1047Hz 125ms ON, 370Hz 125ms",
			" 95    CDMA CALLDROP LITE tone: 1480Hz 125ms, 1397Hz 125ms, 784Hz 125ms",
			" 96    CDMA_NETWORK_BUSY_ONE_SHOT tone: 425Hz 500ms ON, 500ms OFF.",
			" 97    CDMA_ABBR_ALERT tone: 1150Hz+770Hz 400ms ON", " 98    CDMA_SIGNAL_OFF - silent tone" };
	/*
	 * Tone 98 does not work properly on my Lollipop 5.0 devices. Take tone 50 instead.
	 */

	ToneGenerator mToneGenerator;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		final ArrayAdapter<String> tToneInfoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ToneInfo);
		setListAdapter(tToneInfoAdapter);
	}

	@Override
	protected void onResume() {
		super.onResume();
		mToneGenerator = new ToneGenerator(AudioManager.STREAM_SYSTEM, ToneGenerator.MAX_VOLUME);
		final Button button = (Button) findViewById(R.id.buttonStop);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Stop tone
				mToneGenerator.stopTone();
			}
		});
	}

	@Override
	public synchronized void onPause() {
		super.onPause();
		mToneGenerator.release();
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		mToneGenerator.startTone(position);
		Log.d("SystemSoundDemo", "Start tone. toneType=" + position);
	}
}