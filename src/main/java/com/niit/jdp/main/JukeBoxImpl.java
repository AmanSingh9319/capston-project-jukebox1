/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.main;

import com.niit.jdp.service.DatabaseService;

public class JukeBoxImpl {
    public static void main(String[] args) {
        DatabaseService obj = new DatabaseService();
        obj.printConnectionsStatus();
    }
}
