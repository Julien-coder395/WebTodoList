package com.webtodolist.enums;

public enum EnumRole {
	INSTRUCTOR, STUDENT;
	
	public static EnumRole fromInteger(int x) {
        switch(x) {
        case 0:
            return INSTRUCTOR;
        case 1:
            return STUDENT;
        }
        return null;
    }
}


