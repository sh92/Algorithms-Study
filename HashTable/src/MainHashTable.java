
public class MainHashTable {

	public static void main(String[] args) {
		HashTable hash = new HashTable(17, 0.8F);

		System.out.println("Linear Probe");
		hash.put("AT", new Country("Austria", "German", 32378, 8139299));
		hash.put("BE", new Country("Belgium", "Dutch", 11800, 101082034));
		hash.put("DE", new Country("Germany", "German", 137800, 82087361));
		hash.put("DK", new Country("Denmark", "Danish", 16639, 5356845));
		hash.put("ES", new Country("Spain", "Spanish", 194880, 39167744));
		hash.put("FR", new Country("France", "French", 211200, 58978172));
		hash.put("IT", new Country("Italy", "Italian", 116300, 56735130));
		hash.put("LU", new Country("Luxembourg", "French", 998, 429080));
		hash.put("SE", new Country("Sweden", "Portuguese", 35672, 9918040));
		System.out.println("충돌횟수 :" + hash.getCollisionCount());

		DoubleProbeHashTable hash2 = new DoubleProbeHashTable(17, 0.8F);
		System.out.println("Double Probe");
		hash2.put("AT", new Country("Austria", "German", 32378, 8139299));
		hash2.put("BE", new Country("Belgium", "Dutch", 11800, 101082034));
		hash2.put("DE", new Country("Germany", "German", 137800, 82087361));
		hash2.put("DK", new Country("Denmark", "Danish", 16639, 5356845));
		hash2.put("ES", new Country("Spain", "Spanish", 194880, 39167744));
		hash2.put("FR", new Country("France", "French", 211200, 58978172));
		hash2.put("IT", new Country("Italy", "Italian", 116300, 56735130));
		hash2.put("LU", new Country("Luxembourg", "French", 998, 429080));
		hash2.put("SE", new Country("Sweden", "Portuguese", 35672, 9918040));
		System.out.println("충돌횟수 :" + hash2.getCollisionCount());

		DoubleHahsingHashTable hash3 = new DoubleHahsingHashTable(17, 0.8F);
		System.out.println("Double Hasing");
		hash3.put("AT", new Country("Austria", "German", 32378, 8139299));
		hash3.put("BE", new Country("Belgium", "Dutch", 11800, 101082034));
		hash3.put("DE", new Country("Germany", "German", 137800, 82087361));
		hash3.put("DK", new Country("Denmark", "Danish", 16639, 5356845));
		hash3.put("ES", new Country("Spain", "Spanish", 194880, 39167744));
		hash3.put("FR", new Country("France", "French", 211200, 58978172));
		hash3.put("IT", new Country("Italy", "Italian", 116300, 56735130));
		hash3.put("LU", new Country("Luxembourg", "French", 998, 429080));
		hash3.put("SE", new Country("Sweden", "Portuguese", 35672, 9918040));
		System.out.println("충돌횟수 :" + hash3.getCollisionCount());

	}
}
