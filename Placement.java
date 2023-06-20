import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Placement {
    public static void main(String[] args) throws Exception {
        int start;
        FutureBuilder fut;
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to FutureBuilder");
            System.out.println("1.Enter the application");
            System.out.println("2:Exit the application");
            start = inp.nextInt();
            if (start == 1) {
                fut = new FutureBuilder();
                fut.menu();
            } else {
                System.out.println("Thanks for using FututeBuilder");
                break;
            }
        }
    }
}

class FutureBuilder {
    private static ArrayList<Student> stud_arr = new ArrayList<Student>();
    private static ArrayList<Company> comp_arr = new ArrayList<Company>();
    int mode;
    Scanner inp = new Scanner(System.in);

    Placement_Cell pcell;

    public void menu() throws Exception {
        while (true) {
            System.out.println("Choose the mode you want to enter in :");
            System.out.println("1. Enter as student mode");
            System.out.println("2.Enter as company mode");
            System.out.println("3.Enter as placement cell mode");
            System.out.println("4.Return to Main Application");
            mode = inp.nextInt();
            if (mode == 1)
                stud_mode();
            else if (mode == 2)
                comp_mode();
            else if (mode == 3) {
                pcell = new Placement_Cell();
                pcell.menu();
            } else
                break;
        }
    }

    static public ArrayList<Student> get_stud_arr() {
        return stud_arr;
    }

    static public ArrayList<Company> get_comp_arr() {
        return comp_arr;
    }

    private void stud_mode() throws Exception {
        int stud_q;
        while (true) {
            System.out.println("Choose the student query to perform:");
            System.out.println("1.Enter as a Student(Give Student Name, and Roll No.)");
            System.out.println("2.Add students");
            System.out.println("3.Back");
            stud_q = inp.nextInt();
            if (stud_q == 1) {
                enter_stud();
            } else if (stud_q == 2) {
                add_stud();
            } else
                break;
        }
    }

    private void enter_stud() throws Exception {
        String name;
        int roll;
        System.out.print("Enter name of student :");
        inp.nextLine();
        name = inp.nextLine();
        System.out.print("Enter roll no. of student :");
        roll = inp.nextInt();
        for (Student i : stud_arr) {
            // i.enter();
            if (i.getroll() == roll) {
                i.enter();
            }
        }
    }

    private void add_stud() {
        int num;
        System.out.println("Enter no. of students to be added :");
        num = inp.nextInt();
        inp.nextLine();

        for (int i = 0; i < num; i++) {
            Student obj = new Student();
            String nam;
            String br;
            int rolln;
            float gpa;
            System.out.print("Enter student's name :");
            nam = inp.nextLine();
            obj.set_name(nam);
            System.out.print("Enter roll_no. :");
            rolln = inp.nextInt();
            obj.set_roll(rolln);
            System.out.print("Enter cgpa :");
            gpa = inp.nextFloat();
            obj.set_cgpa(gpa);
            System.out.print("Enter branch :");
            inp.nextLine();
            br = inp.nextLine();
            obj.set_br(br);
            stud_arr.add(obj);
        }
    }

    private void comp_mode() throws Exception {
        int comp_q;
        while (true) {
            System.out.println("Choose the Company query to perform:");
            System.out.println("1.Add Company and details");
            System.out.println("2.Choose Company");
            System.out.println("3.Get Available Companies");
            System.out.println("4. Back");
            comp_q = inp.nextInt();
            if (comp_q == 1) {
                comp_add();
            } else if (comp_q == 2) {
                choose_comp();
            } else if (comp_q == 3) {
                avail_comp();
            } else
                break;
        }
    }

    private void comp_add() {
        Company comp = new Company();
        System.out.print("Enter name of company :");
        inp.nextLine();
        comp.set_name(inp.nextLine());
        System.out.print("Enter role offered by company :");
        comp.set_role(inp.nextLine());
        System.out.print("Enter package offered by company in LPA :");
        comp.set_package(inp.nextInt());
        System.out.print("Enter minimum cgpa required by the company :");
        comp.set_cgpa(inp.nextFloat());
        comp_arr.add(comp);
    }

    private void choose_comp() throws Exception {
        int l1;
        int l = comp_arr.size();
        System.out.println("Choose To enter into mode of Available Companies:-");
        for (int i = 0; i < l; i++) {
            System.out.println((i + 1) + "." + comp_arr.get(i).get_name());
        }
        System.out.println("Enter the company you want to enter :");
        l1 = inp.nextInt();
        Company chosen = comp_arr.get(l1 - 1);
        chosen.options();
    }

    private void avail_comp() {
        int l = comp_arr.size();
        for (int i = 0; i < l; i++) {
            System.out.println((i + 1) + "." + comp_arr.get(i).get_name());
        }
    }
}

class Student {
    private ArrayList<Company> app = new ArrayList<Company>();
    private ArrayList<Company> offer = new ArrayList<Company>();
    private Company place;
    boolean accept = false;
    private ArrayList<Company> elig = new ArrayList<Company>();
    FutureBuilder fb;
    boolean reg_s;
    // Company offer;
    boolean offered = false;
    private boolean placed = false;
    private boolean blocled = false;
    private String name;
    private int roll_no;
    private float cgpa;
    private String branch;
    Placement_Cell p;
    Scanner sc = new Scanner(System.in);

    public Company getpl() {
        return this.place;
    }

    public ArrayList<Company> getapp() {
        return this.app;
    }

    public ArrayList<Company> getoff() {
        return this.offer;
    }

    String getbr() {
        return this.branch;
    }

    float get_cg() {
        return this.cgpa;

    }

    boolean get_pstat() {
        return this.placed;
    }

    boolean get_bstat() {
        return this.blocled;
    }

    void set_name(String _name) {
        this.name = _name;
    }

    void set_br(String _name) {
        this.branch = _name;
    }

    void set_roll(int roll) {
        this.roll_no = roll;
    }

    void set_cgpa(float cg) {
        this.cgpa = cg;
    }

    String get_name() {
        return this.name;
    }

    int getroll() {
        return this.roll_no;
    }

    public void enter() throws Exception {
        while (true) {
            int option;
            System.out.println("Welcome  " + this.name);
            System.out.println("1) Register For Placement Drive");
            System.out.println("2) Register For Company");
            System.out.println("3) Get All available companies");
            System.out.println("4) Get Current Status");
            System.out.println("5) Update CGPA");
            System.out.println("6) Accept offer");
            System.out.println("7) Reject offer");
            System.out.println("8) Back");
            option = sc.nextInt();
            if (option == 1) {
                reg_drive(p);
            } else if (option == 2) {
                reg_comp(fb);
            } else if (option == 3) {
                get_avail(fb);
            } else if (option == 4) {
                curr_stat();
            } else if (option == 5) {
                up_cg(p);
            } else if (option == 6) {
                acc();
            } else if (option == 7) {
                rej();
            } else
                break;
        }
    }

    private void acc() {
        Company co = new Company();
        int len = offer.size();
        int pac = 0;
        for (int i = 0; i < len; i++) {
            if (offer.get(i).get_pack() > pac) {
                pac = offer.get(i).get_pack();
                co = offer.get(i);
            }
        }
        this.place = co;
        this.accept = true;
        this.placed = true;
        System.out
                .println("Congratulations " + this.name + "!! You have accepted the offer by " + this.place.get_name());
    }

    private void rej() {
        Company comp = new Company();
        this.accept = false;
        int len = this.offer.size();
        if (len >= 1) {
            comp = this.offer.get(len - 1);
            this.offer.remove(len - 1);
        }
        System.out.println("Offer from  " + comp.get_name() + "  is rejected");
        if (this.offer.size() == 0 && this.offered) {
            System.out.println(this.name + " has been blocked from placement drive");
            this.blocled = true;
        }
    }

    private void reg_drive(Placement_Cell pc) throws Exception {
        String s;
        System.out.println("Enter reg date and time");
        sc.nextLine();
        s = sc.nextLine();
        String[] arr1 = s.split(" ");
        arr1[0] = arr1[0].substring(0, arr1[0].length() - 2);

        String ans1 = "";
        for (int i = 0; i < arr1.length; i++) {
            ans1 += arr1[i] + " ";
        }
        Date reg = new SimpleDateFormat("dd MMMMMMMMM yyyy, HH:mm ").parse(ans1);
        if (reg.compareTo(pc.getos()) < 0) {
            System.out.println("Student registrations haven't opened yet");
        } else if (reg.compareTo(pc.getcs()) > 0) {
            System.out.println("Student registration has closed");
        } else {
            this.reg_s = true;
            System.out.println(this.name + " registered for placement drive at IIITD");
        }
    }

    private void reg_comp(FutureBuilder fb) {
        this.get_avail(fb);
        int reg;
        System.out.println("Enter input :");
        reg = sc.nextInt();
        this.elig.get(reg - 1).reg.add(this);
        app.add(this.elig.get(reg - 1));
        System.out.println("Successfully registered for " + this.elig.get(reg - 1).get_role() + "  role at "
                + this.elig.get(reg - 1).get_name());
    }

    private void get_avail(FutureBuilder fb) {
        if (this.blocled) {
            System.out.println("Blocked");
            System.out.println("Unavailable");
            return;
        }
        ArrayList<Company> c = fb.get_comp_arr();
        int l = c.size();
        elig.clear();
        for (int i = 0; i < l; i++) {
            if (this.placed == false) {
                if (this.cgpa >= c.get(i).get_cg() && c.get(i).reg_c) {
                    this.elig.add(c.get(i));
                }
            } else {
                if (this.cgpa >= c.get(i).get_cg() && c.get(i).get_pack() > 3 * this.place.get_pack()
                        && c.get(i).reg_c) {
                    this.elig.add(c.get(i));
                }
            }
        }
        int len = this.elig.size();
        if (len >= 1) {
            for (int i = 0; i < len; i++) {
                System.out.println((i + 1) + ".)  Company name :" + this.elig.get(i).get_name());
                System.out.println("Company role offering :" + this.elig.get(i).get_role());
                System.out.println("Company Package :" + this.elig.get(i).get_pack());
                System.out.println("Company CGPA criteria :" + this.elig.get(i).get_cg());
                System.out.println();
            }
        } else {
            System.out.println("Unavailable");
        }
    }

    private void curr_stat() {
        if (this.blocled) {
            System.out.println("You have been blocked");
        } else if (this.offered) {
            int len = offer.size();
            for (int i = 0; i < len; i++) {
                System.out.println(
                        "You have been offered by " + this.offer.get(i).get_name() + "!! Please accept the offer");
            }
        } else {
            System.out.println("You have not been offered any package");
        }
    }

    private void up_cg(Placement_Cell p) {
        float num;
        p = new Placement_Cell();
        System.out.println("Enter updated cgpa :");
        num = sc.nextFloat();
        p.update_cg(this, num);
    }

}

class Placement_Cell {
    Scanner inp = new Scanner(System.in);
    int query;
    private static Date open_stud;
    private static Date close_stud;
    private static Date open_comp;
    private static Date close_comp;
    FutureBuilder fut;

    public void menu() throws Exception {
        while (true) {
            System.out.println("Welcome to IIITD Placement Cell");
            System.out.println("1) Open Student Registrations");
            System.out.println("2) Open Company Registrations");
            System.out.println("3) Get Number of Student Registrations");
            System.out.println("4) Get Number of Company Registrations");
            System.out.println("5) Get Number of Offered/Unoffered/Blocked Students");
            System.out.println("6) Get Student Details");
            System.out.println("7) Get Company Details");
            System.out.println("8) Get Average Package");
            System.out.println("9) Get Company Process Results");
            System.out.println("10) Back");
            query = inp.nextInt();
            if (query == 1) {
                open_stud();
            } else if (query == 2) {
                open_comp();
            } else if (query == 3) {
                no_stud(fut);
            } else if (query == 4) {
                no_comp(fut);
            } else if (query == 5) {
                no(fut);
            } else if (query == 6) {
                stud_det(fut);
            } else if (query == 7) {
                comp_det(fut);
            } else if (query == 8) {
                avg(fut);
            } else if (query == 9) {
                cproc(fut);
            } else {
                break;
            }
        }
    }

    public static Date getos() {
        return open_stud;
    }

    public static Date getcs() {
        return close_stud;
    }

    public static Date getcc() {
        return close_comp;
    }

    public static Date getoc() {
        return open_comp;
    }

    private void cproc(FutureBuilder fut) {
        fut = new FutureBuilder();
        ArrayList<Company> com = fut.get_comp_arr();
        System.out.print("Enter name of company :");
        inp.nextLine();
        String name = inp.nextLine();
        for (Company c : com) {
            if (c.get_name().equals(name)) {
                ArrayList<Student> stu = c.getoffered();
                if (stu.size() > 0) {
                    System.out.println("Students who have been offered by this company :");
                    for (int i = 0; i < stu.size(); i++) {
                        System.out.println(stu.get(i).get_name());
                    }
                }
            }
        }
    }

    private void avg(FutureBuilder fut) {
        fut = new FutureBuilder();
        ArrayList<Student> stud = fut.get_stud_arr();
        int sum1 = 0;
        int l = 0;
        int avg;
        int siz = stud.size();
        for (int j = 0; j < siz; j++) {
            if (stud.get(j).get_pstat()) {
                sum1 += stud.get(j).getpl().get_pack();
                l++;
            }
        }
        avg = (sum1) / l;
        System.out.println("Average package of the institute" + avg);
    }

    private void comp_det(FutureBuilder fut) {
        fut = new FutureBuilder();
        ArrayList<Company> com = fut.get_comp_arr();
        System.out.print("Enter name of company :");
        inp.nextLine();
        String name = inp.nextLine();
        for (Company c : com) {
            if (c.get_name() == name) {
                System.out.println("Company details");
                System.out.println("Name :" + c.get_name());
                System.out.println("Package :" + c.get_pack());
                System.out.println("CGPA criteria :" + c.get_cg());
                System.out.println("Role :" + c.get_role());
                ArrayList<Student> stu = c.getoffered();
                if (stu.size() > 0) {
                    System.out.println("Students who have been offered by this company :");
                    for (int i = 0; i < stu.size(); i++) {
                        System.out.println(stu.get(i).get_name());
                    }
                }
            }
        }
    }

    private void stud_det(FutureBuilder fut) {
        fut = new FutureBuilder();
        String name;
        ArrayList<Company> co;
        int roll;
        System.out.print("Enter name of student :");
        inp.nextLine();
        name = inp.nextLine();
        System.out.print("Enter roll no. of student :");
        roll = inp.nextInt();
        for (Student i : fut.get_stud_arr()) {
            if (i.get_name() == name && i.getroll() == roll) {
                co = i.getapp();
                System.out.println("Companies in which student has registered");
                int l = co.size();
                for (int j = 0; j < l; j++) {
                    System.out.println(co.get(j).get_name());
                }
                co = i.getoff();
                System.out.println("Companies in which student is offered");
                l = co.size();
                for (int j = 0; j < l; j++) {
                    System.out.println(co.get(j).get_name());
                }
                break;
            }
        }
    }

    private void no(FutureBuilder fut) {
        fut = new FutureBuilder();
        int pl = 0;
        int upl = 0;
        int bl = 0;
        ArrayList<Student> stud = fut.get_stud_arr();
        int l = stud.size();
        for (int i = 0; i < l; i++) {
            if (stud.get(i).get_pstat()) {
                pl++;
            } else if (stud.get(i).get_bstat()) {
                bl++;
            } else {
                upl++;
            }
        }
        System.out.println("No. of placed students :" + pl);
        System.out.println("No. of blocked students :" + bl);
        System.out.println("No. of unplaced students :" + upl);
    }

    private void open_stud() throws Exception {
        String s1;
        String s2;
        System.out.println("Fill in the details");
        System.out.println("Enter the opening time for student registrations ");
        inp.nextLine();
        s1 = inp.nextLine();
        String[] arr1 = s1.split(" ");
        arr1[0] = arr1[0].substring(0, arr1[0].length() - 2);

        String ans1 = "";
        for (int i = 0; i < arr1.length; i++) {
            ans1 += arr1[i] + " ";
        }
        open_stud = new SimpleDateFormat("dd MMMMMMMMM yyyy, HH:mm ").parse(ans1);

        if (open_stud.compareTo(close_comp) < 0) {
            System.out.println("Student registrations can't start before company registration ends.");
            open_stud();
        }

        System.out.println("Enter the closing time for student registrations ");
        s2 = inp.nextLine();
        String[] arr2 = s2.split(" ");
        arr2[0] = arr2[0].substring(0, arr2[0].length() - 2);

        String ans2 = "";
        for (int i = 0; i < arr2.length; i++) {
            ans2 += arr2[i] + " ";
        }
        close_stud = new SimpleDateFormat("dd MMMMMMMMM yyyy, HH:mm ").parse(ans2);
    }

    private void open_comp() throws Exception {
        String s1;
        String s2;
        System.out.println("Fill in the details");
        System.out.println("Enter the opening time for company registrations ");
        inp.nextLine();
        s1 = inp.nextLine();
        String[] arr1 = s1.split(" ");
        arr1[0] = arr1[0].substring(0, arr1[0].length() - 2);

        String ans1 = "";
        for (int i = 0; i < arr1.length; i++) {
            ans1 += arr1[i] + " ";
        }
        open_comp = new SimpleDateFormat("dd MMMMMMMMM yyyy, HH:mm ").parse(ans1);

        System.out.println("Enter the closing time for company registrations ");
        s2 = inp.nextLine();
        String[] arr2 = s2.split(" ");
        arr2[0] = arr2[0].substring(0, arr2[0].length() - 2);

        String ans2 = "";
        for (int i = 0; i < arr2.length; i++) {
            ans2 += arr2[i] + " ";
        }
        close_comp = new SimpleDateFormat("dd MMMMMMMMM yyyy, HH:mm ").parse(ans2);
    }

    public void update_cg(Student st, float cg) {
        st.set_cgpa(cg);
    }

    private void no_stud(FutureBuilder fut) {
        fut = new FutureBuilder();
        ArrayList<Student> st = fut.get_stud_arr();
        int a = 0;
        int l = st.size();
        for (int i = 0; i < l; i++) {
            if (st.get(i).reg_s) {
                a++;
            }
        }
        System.out.println(a + "students have registered");
    }

    private void no_comp(FutureBuilder fut) {
        fut = new FutureBuilder();
        ArrayList<Company> co = fut.get_comp_arr();
        int a = 0;
        int l = co.size();
        for (int i = 0; i < l; i++) {
            if (co.get(i).reg_c) {
                a++;
            }
        }
        System.out.println(a + "Companies have registered");
    }

}

class Company {
    private ArrayList<Student> offered = new ArrayList<Student>();
    private ArrayList<Student> accept = new ArrayList<Student>();
    Placement_Cell p;
    boolean reg_c;
    ArrayList<Student> reg = new ArrayList<Student>();
    Scanner inp = new Scanner(System.in);
    private String name;
    private String role;
    private int Package;
    private float cg_crit;
    Date d1;

    void options() throws Exception {

        int op;
        while (true) {

            System.out.println("Welcome  " + this.name);
            System.out.println("1. Update role");
            System.out.println("2.Update Package");
            System.out.println("3. Update CGPA criteria");
            System.out.println("4.Register to institute drive");
            System.out.println("5.Get selected students");
            System.out.println("6. back");
            op = inp.nextInt();
            if (op == 1) {
                up_rol();
            } else if (op == 2) {
                up_pack();
            } else if (op == 3) {
                up_cg();
            } else if (op == 4) {
                up_reg(p);
            } else if (op == 5) {
                select();
            } else
                break;
        }
    }

    public ArrayList<Student> getacc() {
        return this.accept;
    }

    public ArrayList<Student> getoffered() {
        return this.offered;
    }

    private void up_rol() {
        String rol;
        System.out.print("Enter the updated role :");
        inp.nextLine();
        rol = inp.nextLine();
        this.role = rol;
    }

    private void up_pack() {
        int pack;
        System.out.print("Enter updated package in LPA :");
        pack = inp.nextInt();
        this.Package = pack;
    }

    private void up_cg() {
        float cg;
        System.out.print("Enter updated cgpa criteria :");
        cg = inp.nextFloat();
        this.cg_crit = cg;
    }

    private void up_reg(Placement_Cell p) throws Exception {
        System.out.println("Enter registration date and time");
        inp.nextLine();
        String date = inp.nextLine();
        System.out.println("Registered !!");
        String[] s1 = date.split(" ");
        s1[0] = s1[0].substring(0, s1[0].length() - 2);
        // s1[1] = s1[1].substring(0, 3);

        String ans = "";
        for (int i = 0; i < s1.length; i++) {
            ans += s1[i] + " ";
        }
        // System.out.println(ans);
        d1 = new SimpleDateFormat("dd MMMMMMMMM yyyy, HH:mm ").parse(ans);
        if (d1.compareTo(p.getoc()) < 0) {
            System.out.println("Company registrations havne't started yet");
        } else if (d1.compareTo(p.getcc()) > 0) {
            System.out.println("Company registrations have closed");
        } else
            this.reg_c = true;
    }

    private void select() {
        Student stu = reg.get(0);
        stu.getoff().add(this);
        stu.offered = true;
        System.out.println(stu.get_name() + " is offered .");
        System.out.println("Roll no :" + stu.getroll());
        System.out.println("Branch is " + stu.getbr());
        System.out.println("Cgpa is :" + stu.get_cg());
        this.offered.add(stu);
    }

    void set_name(String _name) {
        this.name = _name;
    }

    void set_role(String _name) {
        this.role = _name;
    }

    void set_package(int pkg) {
        this.Package = pkg;
    }

    void set_cgpa(float cg) {
        this.cg_crit = cg;
    }

    String get_name() {
        return this.name;
    }

    public float get_cg() {
        return this.cg_crit;
    }

    public int get_pack() {
        return this.Package;
    }

    String get_role() {
        return this.role;
    }
}