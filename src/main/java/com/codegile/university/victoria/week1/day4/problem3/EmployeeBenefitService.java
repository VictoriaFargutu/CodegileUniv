//Creați modelul pentru o instituție care are o bază de date de angajați cărora le pot fi acordate anumite beneficii
// (cafea, card de cumpărături, orice).
//Un beneficiu este acordat la o anumită dată. Scrieți o metodă care afișează un raport al beneficiilor angajate
// tuturor angajaților într-un anumit an dat ca parametru.
//BONUS: Datele salvate într-o bază de date MySQL, datele pentru raport căutându-se prin intermediul unui
// query care verifică anul datei salvată în DB

package com.codegile.university.victoria.week1.day4.problem3;

import java.sql.Date;

public class EmployeeBenefitService {
    public static void main(String[] args){
        getBenefitsReportForAGivenYear("2016");
    }

    public static void getBenefitsReportForAGivenYear(String year){
        SqlEmployeeBenefitRepository sqlEmployeeBenefitRepository = new SqlEmployeeBenefitRepository();
        sqlEmployeeBenefitRepository.readBenefitsForAGivenYear(year);
    }
}
