package generated;

import java.util.HashMap;
import java.util.ArrayList;

public class Peak_footprint {

	public static final String FEATURE_ONE = "one";
	public static final String FEATURE_WIDTH = "width";
	public static final String FEATURE_SURF = "surf";
	public static final String FEATURE_MAX = "max";
	public static final String FEATURE_MIN = "min";
	public static final String FEATURE_RANGE = "range";

	interface I {
		int func();
	}

	private int[] timeSerie;
	private int i;
	private String feature;
	private int default_value;
	private String currentState;
	private HashMap<String, ArrayList<I>> indexedVariablesFunctions;
	private HashMap<String, Integer> registers;
	private HashMap<String, ArrayList<Integer>> results;
	
	public HashMap<String, ArrayList<Integer>> resolve(int[] timeSerie, String feature, int default_value) {
		this.timeSerie = timeSerie;
		this.feature = feature;
		this.default_value = default_value;
		this.i = 0;
		this.currentState = "d";
		this.results = new HashMap<>();
		this.indexedVariablesFunctions = new HashMap<>();
		this.registers = new HashMap<>();
		ArrayList<I> listIp = new ArrayList<I>();
		for(int i = 0; i < timeSerie.length; i++) {
			listIp.add(() -> 0);
		}
		this.indexedVariablesFunctions.put("p", listIp);
		ArrayList<Integer> listIntp = new ArrayList<Integer>();
		for(int i = 0; i < timeSerie.length; i++) {
			listIntp.add(new Integer(0));
		}
		this.results.put("p", listIntp);
		ArrayList<Integer> listIntC = new ArrayList<Integer>();
		for(int i = 0; i < timeSerie.length; i++) {
			listIntC.add(new Integer(0));
		}
		this.registers.put("C", 0);
		this.results.put("C", listIntC);
		while(this.i < timeSerie.length - 1) {
			if (currentState.equals("r")) {
				if (timeSerie[i] > timeSerie[i+1]) {
					found();
					i++;
					currentState = "t";
				}
				else
				if (timeSerie[i] <= timeSerie[i+1]) {
					maybe_before();
					i++;
					currentState = "r";
				}
			} else if (currentState.equals("d")) {
				if (timeSerie[i] >= timeSerie[i+1]) {
					out();
					i++;
					currentState = "d";
				}
				else
				if (timeSerie[i] < timeSerie[i+1]) {
					out();
					i++;
					currentState = "r";
				}
			} else if (currentState.equals("t")) {
				if (timeSerie[i] < timeSerie[i+1]) {
					out_after();
					i++;
					currentState = "r";
				}
				else
				if (timeSerie[i] == timeSerie[i+1]) {
					maybe_after();
					i++;
					currentState = "t";
				}
				else
				if (timeSerie[i] > timeSerie[i+1]) {
					in();
					i++;
					currentState = "t";
				}
			} else {
				break;
			}
		}
		this.indexedVariablesFunctions.forEach((key, value) -> {
			for (int i = value.size() - 1; i >= 0; i--) {
				this.results.get(key).set(i, value.get(i).func());
			}
		});
		return this.results;
	}
	
	
	private void maybe_after() {
		int i = this.i;
		int C = this.registers.get("C");
		I lambda195615004 = () -> this.results.get("p").get(i+1);
		this.indexedVariablesFunctions.get("p").set(i, lambda195615004);
		this.results.get("C").set(i, this.registers.get("C"));
	}
	
	private void maybe_before() {
		int i = this.i;
		int C = this.registers.get("C");
		I lambda1935972447 = () -> this.results.get("p").get(i+1);
		this.indexedVariablesFunctions.get("p").set(i, lambda1935972447);
		this.results.get("C").set(i, this.registers.get("C"));
	}
	
	private void found() {
		int i = this.i;
		int C = this.registers.get("C");
		I lambda97652294 = () -> (C + 1);
		this.indexedVariablesFunctions.get("p").set(i, lambda97652294);
		this.registers.put("C", (C + 1));
		this.results.get("C").set(i, this.registers.get("C"));
	}
	
	private void in() {
		int i = this.i;
		int C = this.registers.get("C");
		I lambda1889248251 = () -> C;
		this.indexedVariablesFunctions.get("p").set(i, lambda1889248251);
		this.results.get("C").set(i, this.registers.get("C"));
	}
	
	private void out_reset() {
		int i = this.i;
		int C = this.registers.get("C");
		I lambda1027007693 = () -> 0;
		this.indexedVariablesFunctions.get("p").set(i, lambda1027007693);
		this.results.get("C").set(i, this.registers.get("C"));
	}
	
	private void found_end() {
		int i = this.i;
		int C = this.registers.get("C");
		I lambda1783047508 = () -> (C + 1);
		this.indexedVariablesFunctions.get("p").set(i, lambda1783047508);
		this.registers.put("C", (C + 1));
		this.results.get("C").set(i, this.registers.get("C"));
	}
	
	private void out_after() {
		int i = this.i;
		int C = this.registers.get("C");
		I lambda2146608740 = () -> 0;
		this.indexedVariablesFunctions.get("p").set(i, lambda2146608740);
		this.results.get("C").set(i, this.registers.get("C"));
	}
	
	private void out() {
		int i = this.i;
		int C = this.registers.get("C");
		I lambda1381713434 = () -> 0;
		this.indexedVariablesFunctions.get("p").set(i, lambda1381713434);
		this.results.get("C").set(i, this.registers.get("C"));
	}

	private int id(String feature) {
		switch(feature) {
			case FEATURE_ONE:
				return 0;
			case FEATURE_WIDTH:
				return 0;
			case FEATURE_SURF:
				return 0;
			case FEATURE_MAX:
				return Integer.MAX_VALUE;
			case FEATURE_MIN:
				return Integer.MIN_VALUE;
			case FEATURE_RANGE:
				return 0;
			default:
				return 0; // TODO: throw error
		}
	}

	private int min(String feature) {
		switch(feature) {
			case FEATURE_ONE:
				return 0;
			case FEATURE_WIDTH:
				return 0;
			case FEATURE_SURF:
				return Integer.MIN_VALUE;
			case FEATURE_MAX:
				return Integer.MIN_VALUE;
			case FEATURE_MIN:
				return Integer.MIN_VALUE;
			case FEATURE_RANGE:
				return 0;
			default:
				return 0; // TODO: throw error
		}
	}

	private int max(String feature) {
		switch(feature) {
			case FEATURE_ONE:
				return 1;
			case FEATURE_WIDTH:
				return this.timeSerie.length + 1;
			case FEATURE_SURF:
				return Integer.MAX_VALUE;
			case FEATURE_MAX:
				return Integer.MAX_VALUE;
			case FEATURE_MIN:
				return Integer.MAX_VALUE;
			case FEATURE_RANGE:
				return Integer.MAX_VALUE;
			default:
				return 0; // TODO: throw error
		}
	}

	private int phi(String feature, int arg1, int arg2) {
		switch(feature) {
			case FEATURE_ONE:
				return Math.max(arg1, arg2);
			case FEATURE_WIDTH:
				return arg1 + arg2;
			case FEATURE_SURF:
				return arg1 + arg2;
			case FEATURE_MAX:
				return Math.max(arg1, arg2);
			case FEATURE_MIN:
				return Math.min(arg1, arg2);
			case FEATURE_RANGE:
				return 0; // TODO: throw error
			default:
				return 0; // TODO: throw error;
		}
	}

	private int delta(String feature, int index) {
		switch(feature) {
			case FEATURE_ONE:
				return 1;
			case FEATURE_WIDTH:
				return 1;
			case FEATURE_SURF:
				return this.timeSerie[index];
			case FEATURE_MAX:
				return this.timeSerie[index];
			case FEATURE_MIN:
				return this.timeSerie[index];
			case FEATURE_RANGE:
				return this.timeSerie[index];
			default:
				return 0; // TODO: throw error
		}
	}

	private int delta2(String feature, int index) {
		switch(feature) {
			case FEATURE_ONE:
				return -1;
			case FEATURE_WIDTH:
				return -1;
			case FEATURE_SURF:
				return (-1) * this.timeSerie[index];
			case FEATURE_MAX:
				return 0; // TODO: throw error
			case FEATURE_MIN:
				return 0; // TODO: throw error
			case FEATURE_RANGE:
				return 0; // TODO: throw error
			default:
				return 0; // TODO: throw error
		}
	}

	public int default_fun(String feature) {
		return this.default_value;
	}
}
