import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PolynomialSolver {
    public static void main(String[] args) throws Exception {
        // Read JSON input (make sure input.json is in same folder)
        String content = new String(Files.readAllBytes(Paths.get("input.json")));
        JSONObject json = new JSONObject(content);

        // Extract keys
        JSONObject keys = json.getJSONObject("keys");
        int n = keys.getInt("n");
        int k = keys.getInt("k");

        // Extract roots from JSON
        List<Integer> roots = new ArrayList<>();
        for (String key : json.keySet()) {
            if (!key.equals("keys")) {
                JSONObject obj = json.getJSONObject(key);
                int base = Integer.parseInt(obj.getString("base"));
                String value = obj.getString("value");
                int decimal = Integer.parseInt(value, base);
                roots.add(decimal);
            }
        }

        // Sort roots for consistency
        Collections.sort(roots);

        // Take first k roots
        List<Integer> selectedRoots = roots.subList(0, k);

        // Generate polynomial coefficients
        List<Integer> coeffs = getPolynomialCoefficients(selectedRoots);

        // Print result
        System.out.println("Selected Roots: " + selectedRoots);
        System.out.println("Polynomial coefficients: " + coeffs);
    }

    // Multiply polynomials using roots
    private static List<Integer> getPolynomialCoefficients(List<Integer> roots) {
        List<Integer> coeffs = new ArrayList<>();
        coeffs.add(1); // start with leading coefficient 1

        for (int root : roots) {
            List<Integer> newCoeffs = new ArrayList<>();
            newCoeffs.add(coeffs.get(0)); // keep leading coefficient

            for (int i = 1; i < coeffs.size(); i++) {
                int val = coeffs.get(i) - root * coeffs.get(i - 1);
                newCoeffs.add(val);
            }

            newCoeffs.add(-root * coeffs.get(coeffs.size() - 1));
            coeffs = newCoeffs;
        }
        return coeffs;
    }
}
