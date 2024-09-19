package cicd;



public class Student {

    private long id ;
    private String name;
    private String className;
    private int age;
    private String address;
    private int englishScore;
    private int literatureScore;
    private int mathScore;
    private int physicsScore;
    private int chemistryScore;


    public Student() {
    }

    public Student(long id ,String name, String className, int age, String address, int englishScore, int literatureScore, int mathScore, int physicsScore, int chemistryScore) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.age = age;
        this.address = address;
        this.englishScore = englishScore;
        this.literatureScore = literatureScore;
        this.mathScore = mathScore;
        this.physicsScore = physicsScore;
        this.chemistryScore = chemistryScore;
    }

    // Getter và Setter cho các trường dữ liệu

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getLiteratureScore() {
        return literatureScore;
    }

    public void setLiteratureScore(int literatureScore) {
        this.literatureScore = literatureScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getPhysicsScore() {
        return physicsScore;
    }

    public void setPhysicsScore(int physicsScore) {
        this.physicsScore = physicsScore;
    }

    public int getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(int chemistryScore) {
        this.chemistryScore = chemistryScore;
    }
}

