import java.util.Scanner;

class marksManagement {
    static Scanner input = new Scanner(System.in);

    static String[] sIdarr = new String[0];
    static String[] Snamearr = new String[0];
    static double[] PMarks = new double[0];
    static double[] DMarks = new double[0];

    public static void main(String[] args) {

        homePage();
    }

    //teatinggggggggg

    // ADD NEW STUDENT
    public static void addNewStudent() {
        printLine();
        System.out.println("|\t\t\t\t\t\tADD NEW STUDENT\t\t\t\t\t\t\t|");
        printLine();
//////////////
        while (true) {
            String[] tempId = new String[sIdarr.length + 1];
            String[] tempname = new String[sIdarr.length + 1];
            double[] tempPMarks = new double[sIdarr.length + 1];
            double[] tempDMarks = new double[sIdarr.length + 1];

            System.out.print("Enter Student ID   : ");
            String SID = input.next();

            Boolean idExist = false;

            for (int i = 0; i < sIdarr.length; i++) {
                if (isStringEqual(sIdarr[i], SID)) {
                    idExist = true;
                    break;
                }
            }

            if (idExist) {
                System.out.println("Student ID already exists. Please enter a different ID.");
                System.out.println();
                continue;
            }

            for (int i = 0; i < sIdarr.length; i++) {

                tempId[i] = sIdarr[i];
                tempname[i] = Snamearr[i];
                tempPMarks[i] = PMarks[i];
                tempDMarks[i] = DMarks[i];

            }
            tempId[tempId.length - 1] = SID;
            sIdarr = tempId;

            System.out.print("Enter Student Name : ");
            String Sname = input.next();

            tempname[tempname.length - 1] = Sname;
            Snamearr = tempname;

            tempPMarks[tempPMarks.length - 1] = -1;
            PMarks = tempPMarks;

            tempDMarks[tempDMarks.length - 1] = -1;
            DMarks = tempDMarks;

            System.out.print("\nStudent has been added successfully.Do you want to add a new student (Y/N) : ");
            String cmd = input.next();
            System.out.println();
            if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                break;
            }
        }
        homePage();

    }

    // ADD NEW STUDENT WITH MARKS
    public static void addNewStudentWithMarks() {
        printLine();
        System.out.println("|\t\t\t\t\tADD NEW STUDENT WITH MARKS\t\t\t\t\t\t|");
        printLine();

        while (true) {
            String[] tempId = new String[sIdarr.length + 1];
            String[] tempname = new String[sIdarr.length + 1];
            double[] tempPMarks = new double[sIdarr.length + 1];
            double[] tempDMarks = new double[sIdarr.length + 1];

            System.out.print("Enter Student ID   : ");
            String SID = input.next();

            Boolean idExist = false;

            for (int i = 0; i < sIdarr.length; i++) {
                if (isStringEqual(sIdarr[i], SID)) {
                    idExist = true;
                    break;
                }
            }

            if (idExist) {
                System.out.println("Student ID already exists. Please enter a different ID.");
                System.out.println();
                continue;
            }

            for (int i = 0; i < sIdarr.length; i++) {

                tempId[i] = sIdarr[i];
                tempname[i] = Snamearr[i];
                tempPMarks[i] = PMarks[i];
                tempDMarks[i] = DMarks[i];

            }

            tempId[tempId.length - 1] = SID;
            sIdarr = tempId;

            System.out.print("Enter Student Name : ");
            String Sname = input.next();

            tempname[tempname.length - 1] = Sname;
            Snamearr = tempname;

            System.out.print("Programming Fundamentals Marks     : ");
            double Pmarks = input.nextInt();

            while (Pmarks < 0 || Pmarks > 100) {
                System.out.println("Invalid Marks.Please enter correct marks.\n");
                System.out.print("Programming Fundamentals Marks     : ");
                Pmarks = input.nextInt();
            }

            tempPMarks[tempPMarks.length - 1] = Pmarks;
            PMarks = tempPMarks;

            System.out.print("Database Management System Marks   : ");
            double Dmarks = input.nextInt();

            while (Dmarks < 0 || Dmarks > 100) {
                System.out.println("Invalid Marks.Please enter correct marks.\n");
                System.out.print("Database Management System Marks   : ");
                Dmarks = input.nextInt();
            }

            tempDMarks[tempDMarks.length - 1] = Dmarks;
            DMarks = tempDMarks;

            System.out.print("\nStudent has been added successfully.Do you want to add a new student (Y/N) : ");
            String cmd = input.next();
            System.out.println();
            if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                break;
            }
        }
        homePage();
    }

    // ADD MARKS
    public static void addMarks() {
        printLine();
        System.out.println("|\t\t\t\t\t\tADD MARKS\t\t\t\t\t\t\t|");
        printLine();

        while (true) {
            System.out.println();
            System.out.print("Enter Student ID   : ");
            String SID = input.next();

            int index = -1;

            for (int i = 0; i < sIdarr.length; i++) {
                if (isStringEqual(sIdarr[i], SID)) {
                    index = i;
                    break;
                }

            }

            if (index == -1) {
                System.out.print("Invalid Student ID. Do you want a search again? (Y/N) :");
                String cmd = input.next();
                System.out.println();
                if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                    break;
                } else {
                    continue;
                }
            }

            if (PMarks[index] != -1) {
                System.out.print("Student Name      : " + Snamearr[index]);
                System.out.print(
                        "\nThis student marks have been already added.\nIf you want to update the marks,please use [5]Update Marks option.\n\nDo you want to add marks for another student? (Y/N) :  ");
                String cmd = input.next();
                System.out.println();
                if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                    break;
                } else {
                    continue;
                }
            }

            System.out.println("Student Name      : " + Snamearr[index]);
            System.out.print("Programming Fundamentals Marks     : ");
            double Pmarks = input.nextInt();

            while (Pmarks < 0 || Pmarks > 100) {
                System.out.println("Invalid Marks.Please enter correct marks.\n");
                System.out.print("Programming Fundamentals Marks     : ");
                Pmarks = input.nextInt();
            }

            PMarks[index] = Pmarks;

            System.out.print("Database Management System Marks    : ");
            double Dmarks = input.nextInt();

            while (Dmarks < 0 || Dmarks > 100) {
                System.out.println("Invalid Marks.Please enter correct marks.\n");
                System.out.print("Database Management System Marks    : ");
                Dmarks = input.nextInt();
            }

            DMarks[index] = Dmarks;

            System.out.print("\nMarks have been added .Do you want to add marks for another student? (Y/N) : ");
            String cmd = input.next();
            System.out.println();
            if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                break;
            }
        }
        homePage();
    }

    // UPDATE STUDENT DETAILS
    public static void updateStudentDetails() {
        printLine();
        System.out.println("|\t\t\t\t\tUPDATE STUDENT DETAILS\t\t\t\t\t\t\t|");
        printLine();

        while (true) {
            System.out.print("Enter Student ID   : ");
            String SID = input.next();

            Boolean idExist = false;
            int index = -1;

            for (int i = 0; i < sIdarr.length; i++) {
                if (isStringEqual(sIdarr[i], SID)) {
                    idExist = true;
                    index = i;
                    break;
                }
            }

            if (idExist) {
                System.out.println("Student Name       : " + Snamearr[index]);
                System.out.print("\nEnter the new Student Name : ");
                String updatedName = input.next();

                Snamearr[index] = updatedName;

                System.out.print(
                        "\nStudent details has been updated successfully.\nDo you want to update another student details? (Y/N) : ");
                String cmd = input.next();
                System.out.println();
                if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                    break;
                }
                continue;

            } else {
                System.out.print("Invalid Student ID. Do you want a search again? (Y/N) :");
                String cmd = input.next();
                System.out.println();
                if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                    break;
                }
                continue;
            }
        }
        homePage();
    }

    // UPDATE MARKS
    public static void updateMarks() {
        printLine();
        System.out.println("|\t\t\t\t\t\tUPDATE MARKS\t\t\t\t\t\t\t|");
        printLine();

        while (true) {
            System.out.print("Enter Student ID   : ");
            String SID = input.next();

            Boolean idExist = false;
            int index = -1;

            for (int i = 0; i < sIdarr.length; i++) {
                if (isStringEqual(sIdarr[i], SID)) {
                    idExist = true;
                    index = i;
                    break;
                }
            }

            if (idExist) {
                System.out.println("Student Name       : " + Snamearr[index]);

                if ((PMarks[index] == -1) && (DMarks[index] == -1)) {
                    System.out.print(
                            "\nThis Student marks yet to added.\nDo you want to update the marks another student? (Y/N) : ");
                    String cmd = input.next();
                    System.out.println();
                    if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                        break;
                    }
                    continue;
                } else {
                    System.out.println("Programming Fundamentals Marks     : " + PMarks[index]);
                    System.out.print("Database Management System Marks   : " + DMarks[index]);
                    System.out.println();
                    System.out.print("\nEnter new Programming Fundamentals Marks   : ");
                    double Pmarks = input.nextInt();

                    while (Pmarks < 0 || Pmarks > 100) {
                        System.out.println("Invalid Marks.Please enter correct marks.\n");
                        System.out.print("Enter new Programming Fundamentals Marks   : ");
                        Pmarks = input.nextInt();
                    }

                    PMarks[index] = Pmarks;

                    System.out.print("Enter new Database Management System Marks : ");
                    double Dmarks = input.nextInt();

                    while (Dmarks < 0 || Dmarks > 100) {
                        System.out.println("Invalid Marks.Please enter correct marks.\n");
                        System.out.print("Enter new Database Management System Marks : ");
                        Dmarks = input.nextInt();
                    }
                    DMarks[index] = Dmarks;

                    System.out.print(
                            "Marks have been updated successfully.\nDo you want to update marks for another student? (Y/N) : ");
                    String cmd = input.next();
                    System.out.println();
                    if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                        break;
                    }
                    continue;
                }
            } else {
                System.out.print("Invalid Student ID. Do you want a search again? (Y/N) :");
                String cmd = input.next();
                System.out.println();
                if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                    break;
                }
                continue;
            }
        }
        homePage();
    }

    // DELETE STUDENT
    public static void deleteStudent() {
        printLine();
        System.out.println("|\t\t\t\t\t\tDELETE STUDENT\t\t\t\t\t\t\t|");
        printLine();

        while (true) {
            System.out.print("Enter Student ID   : ");
            String SID = input.next();

            Boolean idExist = false;
            int index = -1;

            for (int i = 0; i < sIdarr.length; i++) {
                if (isStringEqual(sIdarr[i], SID)) {
                    idExist = true;
                    index = i;
                    break;
                }
            }

            if (idExist) {
                sIdarr = remove(sIdarr, index);
                Snamearr = remove(Snamearr, index);
                PMarks = removemarks(PMarks, index);
                DMarks = removemarks(DMarks, index);
                System.out.print(
                        "Student has been deleted successfullt.\nDo you want to delete another student? (Y/N) : ");
                String cmd = input.next();
                if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                    break;
                }
                continue;
            } else {
                System.out.print("Invalid Student ID. Do you want a search again? (Y/N) :");
                String cmd = input.next();
                System.out.println();
                if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                    break;
                }
                continue;
            }
        }
        homePage();
    }

    // PRINT STUDENT DETAILS
    public static void printStudentDetails() {
        printLine();
        System.out.println("|\t\t\t\t\t\tPRINT STUDENT DETAILS\t\t\t\t\t\t|");
        printLine();

        while (true) {
            System.out.println();
            System.out.print("Enter Student ID   : ");
            String SID = input.next();

            int index = -1;
            double Total;
            double Average;
            String rank;

            for (int i = 0; i < sIdarr.length; i++) {
                if (isStringEqual(sIdarr[i], SID)) {
                    index = i;
                    break;
                }

            }

            if (index == -1) {
                System.out.print("Invalid Student ID. Do you want a search again? (Y/N) :");
                String cmd = input.next();
                System.out.println();
                if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                    break;
                } else {
                    continue;
                }
            }

            if (PMarks[index] != -1) {
                Total = total(PMarks[index], DMarks[index]);
                Average = average(Total, 2);
                rank = rank(Average);

                System.out.println("Student Name      : " + Snamearr[index]);
                System.out.println("+------------------------------------------------------------------+");
                System.out.print("| Programming Fundamentals Marks                   |\t");
                System.out.print(PMarks[index]);
                System.out.println("       |");

                System.out.print("| Database Management System Marks                 |\t");
                System.out.print(DMarks[index]);
                System.out.println("       |");

                System.out.print("| Total Marks                                      |\t");
                System.out.print(Total);
                System.out.println("      |");

                System.out.print("| Avg. Marks                                       |\t");
                System.out.print(Average);
                System.out.println("       |");

                System.out.print("| Rank                                             |\t");
                System.out.print(rank);
                System.out.println("  |");

                System.out.println("+------------------------------------------------------------------+");
                System.out.print("\nDo you want to search  another student details? (Y/N) : ");
                String cmd = input.next();
                System.out.println();
                if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                    break;
                } else {
                    continue;
                }
            }

            System.out.print("\nMarks yet to be added.\nDo you want to search another student details? (Y/N) : ");
            String cmd = input.next();
            System.out.println();
            if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                break;
            }
        }
        homePage();

    }

    // PRINT STUDENT RANKS
    public static void printStudentRanks() {
        printLine();
        System.out.println("|\t\t\t\t\t\tPRINT STUDENT'S RANKS\t\t\t\t\t\t|");
        printLine();

        int validc = 0;

        for (int i = 0; i < sIdarr.length; i++) {
            if (PMarks[i] != -1 && DMarks[i] != -1) {
                validc++;
            }
        }

        double[] avgarray = new double[validc];
        double[] totalarray = new double[validc];
        String[] validSid = new String[validc];
        String[] validName = new String[validc];

        int index = 0;

        for (int i = 0; i < sIdarr.length; i++) {
            if (PMarks[i] != -1 && DMarks[i] != -1) {
                totalarray[index] = PMarks[i] + DMarks[i];
                avgarray[index] = totalarray[index] / 2.0;
                validSid[index] = sIdarr[i];
                validName[index] = Snamearr[i];
                index++;
            }

        }

        for (int j = validc - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (avgarray[i] < avgarray[i + 1]) {
                    double a = avgarray[i];
                    avgarray[i] = avgarray[i + 1];
                    avgarray[i + 1] = a;

                    double t = totalarray[i];
                    totalarray[i] = totalarray[i + 1];
                    totalarray[i + 1] = t;

                    String id = validSid[i];
                    validSid[i] = validSid[i + 1];
                    validSid[i + 1] = id;

                    String na = validName[i];
                    validName[i] = validName[i + 1];
                    validName[i + 1] = na;
                }
            }
        }

        System.out.println("\n");
        while (true) {
            System.out
                    .println("+--------+-----------+-----------------------+-------------------+-------------------+");
            System.out
                    .println("|Rank    |ID         |Name                   |Total Marks        |Avg.Marks          |");
            System.out
                    .println("+--------+-----------+-----------------------+-------------------+-------------------+");

            for (int i = 0; i < validc; i++) {
                int d = i + 1;
                System.out.printf("| %-6d | %-9s | %-21s | %-17.1f | %-17.1f |\n",
                        d, validSid[i], validName[i], totalarray[i], avgarray[i]);
            }

            System.out
                    .println("+--------+-----------+-----------------------+-------------------+-------------------+");

            System.out.print("\nDo you want to go back to main mainu? (Y/N) : ");
            String cmd = input.next();
            System.out.println();
            if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                continue;
            } else {
                break;
            }
        }
        homePage();

    }

    // best in programming
    public static void bestInProgrammingFundamentals() {
        printLine();
        System.out.println("|\t\t\t\t\t\tPRINT STUDENT'S RANKS\t\t\t\t\t\t|");
        printLine();

        int validc = 0;

        for (int i = 0; i < sIdarr.length; i++) {
            if (PMarks[i] != -1) {
                validc++;
            }
        }

        double[] validP = new double[validc];
        double[] validD = new double[validc];
        String[] validSid = new String[validc];
        String[] validName = new String[validc];

        int index = 0;

        for (int i = 0; i < sIdarr.length; i++) {
            if (PMarks[i] != -1) {
                validSid[index] = sIdarr[i];
                validName[index] = Snamearr[i];
                validP[index] = PMarks[i];
                validD[index] = DMarks[i];

                index++;
            }

        }

        for (int j = validc - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (validP[i] < validP[i + 1]) {

                    double p = validP[i];
                    validP[i] = validP[i + 1];
                    validP[i + 1] = p;

                    double d = validD[i];
                    validD[i] = validD[i + 1];
                    validD[i + 1] = d;

                    String id = validSid[i];
                    validSid[i] = validSid[i + 1];
                    validSid[i + 1] = id;

                    String na = validName[i];
                    validName[i] = validName[i + 1];
                    validName[i + 1] = na;
                }
            }
        }

        System.out.println("\n");
        while (true) {
            System.out.println("+-----------+-----------------------+-------------------+-------------------+");
            System.out.println("|ID         |Name                   |PF Marks           |DBMS Marks         |");
            System.out.println("+-----------+-----------------------+-------------------+-------------------+");

            for (int i = 0; i < validc; i++) {
                System.out.printf("| %-9s | %-21s | %-17.1f | %-17.1f |\n", validSid[i], validName[i], validP[i],
                        validD[i]);
            }

            System.out.println("+-----------+-----------------------+-------------------+-------------------+");

            System.out.print("\nDo you want to go back to main mainu? (Y/N) : ");
            String cmd = input.next();
            System.out.println();
            if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                continue;
            } else {
                break;
            }
        }
        homePage();
    }

    // BEST IN DBMS
    public static void bestInDBMS() {
        printLine();
        System.out.println("|\t\t\t\t\t\tPRINT STUDENT'S RANKS\t\t\t\t\t\t|");
        printLine();

        int validc = 0;

        for (int i = 0; i < sIdarr.length; i++) {
            if (DMarks[i] != -1) {
                validc++;
            }
        }

        double[] validP = new double[validc];
        double[] validD = new double[validc];
        String[] validSid = new String[validc];
        String[] validName = new String[validc];

        int index = 0;

        for (int i = 0; i < sIdarr.length; i++) {
            if (DMarks[i] != -1) {
                validSid[index] = sIdarr[i];
                validName[index] = Snamearr[i];
                validP[index] = PMarks[i];
                validD[index] = DMarks[i];

                index++;
            }

        }

        for (int j = validc - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (validD[i] < validD[i + 1]) {

                    double p = validP[i];
                    validP[i] = validP[i + 1];
                    validP[i + 1] = p;

                    double d = validD[i];
                    validD[i] = validD[i + 1];
                    validD[i + 1] = d;

                    String id = validSid[i];
                    validSid[i] = validSid[i + 1];
                    validSid[i + 1] = id;

                    String na = validName[i];
                    validName[i] = validName[i + 1];
                    validName[i + 1] = na;
                }
            }
        }

        System.out.println("\n");
        while (true) {
            System.out.println("+-----------+-----------------------+-------------------+-------------------+");
            System.out.println("|ID         |Name                   |DBMS Marks         |PF Marks         |");
            System.out.println("+-----------+-----------------------+-------------------+-------------------+");

            for (int i = 0; i < validc; i++) {
                System.out.printf("| %-9s | %-21s | %-17.1f | %-17.1f |\n", validSid[i], validName[i], validD[i],
                        validP[i]);
            }

            System.out.println("+-----------+-----------------------+-------------------+-------------------+");

            System.out.print("\nDo you want to go back to main mainu? (Y/N) : ");
            String cmd = input.next();
            System.out.println();
            if (!isStringEqual(cmd, "Y") && !isStringEqual(cmd, "y")) {
                continue;
            } else {
                break;
            }
        }
        homePage();
    }

    // RANK
    public static String rank(double rnk) {
        double[] avgarr = new double[sIdarr.length];

        double total = 0;
        double avg = 0;
        int rank = 0;
        String x = " ";

        for (int i = 0; i < sIdarr.length; i++) {
            total = PMarks[i] + DMarks[i];
            avg = total / 2;

            avgarr[i] = avg;
        }

        avgarr = removeDuplicate(avgarr);
        avgarr = sort(avgarr);

        for (int i = 0; i < avgarr.length; i++) {
            if (avgarr[i] == rnk) {
                rank = i + 1;
                if (rank == 1) {
                    x = "1 (First)";
                } else if (rank == 2) {
                    x = "2 (Second)";
                } else if (rank == 3) {
                    x = "3 (Third)";
                } else if (rank == avgarr.length) {
                    x = "Last";
                } else {
                    x = "" + rank;
                }
                break;
            }

        }
        return x;
    }

    // check duplicate
    public static boolean isDuplicate(double[] ar, double value) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == value) {
                return true;
            }
        }
        return false;
    }

    // remove duplicate from avg array
    public static double[] removeDuplicate(double[] ar) {
        double br[] = new double[0];
        for (int i = 0; i < ar.length; i++) {
            if (!isDuplicate(br, ar[i])) {
                double temp[] = new double[br.length + 1];
                for (int j = 0; j < br.length; j++) {
                    temp[j] = br[j];
                }
                temp[temp.length - 1] = ar[i];
                br = temp;
            }
        }
        return br;
    }

    // sort avg array
    public static double[] sort(double[] ar) {
        for (int j = ar.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (ar[i] < ar[i + 1]) {
                    double t = ar[i];
                    ar[i] = ar[i + 1];
                    ar[i + 1] = t;
                }
            }
        }
        return ar;
    }

    // PRINT TOTAL
    public static double total(double PFmarks, double DBMSmarks) {
        return PFmarks + DBMSmarks;
    }

    // PRINT AVERAGE
    public static double average(double tot, int count) {
        return tot / count;
    }

    // REMOVE STRING ARRAY INDEX
    public static String[] remove(String[] arr, int index) {
        String[] newarr = new String[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newarr[j] = arr[i];
                j++;
            }
        }
        return newarr;
    }

    // REMOVE INT ARRAY INDEX
    public static double[] removemarks(double[] arr, int index) {
        double[] newarr = new double[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newarr[j] = arr[i];
                j++;
            }
        }
        return newarr;
    }

    // compare String
    public static boolean isStringEqual(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // clear console
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace(); // Handle any exceptions.
        }
    }

    // print line
    public static void printLine() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------");
    }

    // Home Page
    public static void homePage() {
        clearConsole();
        printLine();
        System.out.println("|\t\t\t\t\tWELCOME TO CMJD MARKS MANAGEMENT SYSTEM\t\t\t\t\t|");
        printLine();
        System.out.println("[1] Add New Student                 \t\t\t\t[2]Add New Student With Marks");
        System.out.println("[3] Add Marks                       \t\t\t\t[4]Update Student Details");
        System.out.println("[5] Update Marks                    \t\t\t\t[6]Delete Student");
        System.out.println("[7] Print Student Details           \t\t\t\t[8]Print Student Ranks");
        System.out.println("[9] Best in Programming Fundamentals\t\t\t\t[10]Best in Database Management System");
        System.out.print("\nEnter an Option to continue > ");
        int option1 = input.nextInt();

        clearConsole();

        switch (option1) {
            case 1:
                addNewStudent();
                break;
            case 2:
                addNewStudentWithMarks();
                break;
            case 3:
                addMarks();
                break;
            case 4:
                updateStudentDetails();
                break;
            case 5:
                updateMarks();
                break;
            case 6:
                deleteStudent();
                break;
            case 7:
                printStudentDetails();
                break;
            case 8:
                printStudentRanks();
                break;

            case 9:
                bestInProgrammingFundamentals();
                break;
            case 10:
                bestInDBMS();
                break;

            default:
                System.out.println("ERROR : INVALID OPTION");
                break;
        }

    }

}