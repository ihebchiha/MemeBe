package com.gobeyond.memebe.enumeration;

public enum UserRole {
    GUEST, USER, ADMIN, VIP;

    public static String toUserRoleAsString(UserRole userRole) {
        switch (userRole) {
        case ADMIN:
            return "ADMIN";
        case USER:
            return "USER";
        case GUEST:
            return "GUEST";
        case VIP:
            return "VIP";
        default:
            return null;
        }
    }
}