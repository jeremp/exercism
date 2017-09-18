
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



/**
 *
 * @author jpasseron
 */
public class KindergartenGarden {

	private static final String SPLIT_STR = "\n";
	private String ALPHABET = "ABCDEFGHIJKLMNOPQRSTWXYZ";
	private String firstRow ;
	private String secondRow ;
	
	public KindergartenGarden(String plants) {
		this(plants, new String[0]);
	}

	public KindergartenGarden(String plants, String[] studentArray) {		
		String[] rows = plants.split(SPLIT_STR);
		if(studentArray.length>0){
			ALPHABET = Arrays.asList(studentArray).stream().sorted().map((t) -> {
				return t.substring(0, 1);
			}).collect(Collectors.joining());
		}
		firstRow = rows[0];
		secondRow = rows[1];
	}

	public List<Plant> getPlantsOfStudent(String student) {
		List<Plant> res = new ArrayList<>();
		int index = getStudentTurn(student);		
		res.add(Plant.getPlant(firstRow.substring(index, index+1).charAt(0)));
		res.add(Plant.getPlant(firstRow.substring(index+1, index+2).charAt(0)));
		res.add(Plant.getPlant(secondRow.substring(index, index+1).charAt(0)));
		res.add(Plant.getPlant(secondRow.substring(index+1, index+2).charAt(0)));
		return res;
	}
	
	private int getStudentTurn(String student){
		String initiale = student.substring(0, 1);
		return ALPHABET.indexOf(initiale.toUpperCase())*2;
	}
	
}
