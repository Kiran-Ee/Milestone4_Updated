package Milestone4Tests.CPU;

import CPU.CPU;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetRegistersStateTest {
    HashMap<String, Integer> hm = null; //defined in @BeforeEach

    // Define string variables for each register key
    String zero = "$zero";
    String at = "$at";
    String v0 = "$v0";
    String v1 = "$v1";
    String a0 = "$a0";
    String a1 = "$a1";
    String a2 = "$a2";
    String a3 = "$a3";
    String t0 = "$t0";
    String t1 = "$t1";
    String t2 = "$t2";
    String t3 = "$t3";
    String t4 = "$t4";
    String t5 = "$t5";
    String t6 = "$t6";
    String t7 = "$t7";
    String s0 = "$s0";
    String s1 = "$s1";
    String s2 = "$s2";
    String s3 = "$s3";
    String s4 = "$s4";
    String s5 = "$s5";
    String s6 = "$s6";
    String s7 = "$s7";
    String t8 = "$t8";
    String t9 = "$t9";
    String k0 = "$k0";
    String k1 = "$k1";
    String gp = "$gp";
    String sp = "$sp";
    String fp = "$fp";
    String ra = "$ra";

    // Create corresponding int variables for each register
    int int_zero = 0;
    int int_at = 1;
    int int_v0 = 2;
    int int_v1 = 3;
    int int_a0 = 4;
    int int_a1 = 5;
    int int_a2 = 6;
    int int_a3 = 7;
    int int_t0 = 8;
    int int_t1 = 9;
    int int_t2 = 10;
    int int_t3 = 11;
    int int_t4 = 12;
    int int_t5 = 13;
    int int_t6 = 14;
    int int_t7 = 15;
    int int_s0 = 16;
    int int_s1 = 17;
    int int_s2 = 18;
    int int_s3 = 19;
    int int_s4 = 20;
    int int_s5 = 21;
    int int_s6 = 22;
    int int_s7 = 23;
    int int_t8 = 24;
    int int_t9 = 25;
    int int_k0 = 26;
    int int_k1 = 27;
    int int_gp = 28;
    int int_sp = 0x7fffeffc;
    int int_fp = 30;
    int int_ra = 31;

    @BeforeEach
    public void setUp() {
        CPU.zero = int_zero;
        CPU.at = int_at;
        CPU.v0 = int_v0;
        CPU.v1 = int_v1;
        CPU.a0 = int_a0;
        CPU.a1 = int_a1;
        CPU.a2 = int_a2;
        CPU.a3 = int_a3;
        CPU.t0 = int_t0;
        CPU.t1 = int_t1;
        CPU.t2 = int_t2;
        CPU.t3 = int_t3;
        CPU.t4 = int_t4;
        CPU.t5 = int_t5;
        CPU.t6 = int_t6;
        CPU.t7 = int_t7;
        CPU.s0 = int_s0;
        CPU.s1 = int_s1;
        CPU.s2 = int_s2;
        CPU.s3 = int_s3;
        CPU.s4 = int_s4;
        CPU.s5 = int_s5;
        CPU.s6 = int_s6;
        CPU.s7 = int_s7;
        CPU.t8 = int_t8;
        CPU.t9 = int_t9;
        CPU.k0 = int_k0;
        CPU.k1 = int_k1;
        CPU.gp = int_gp;
        CPU.sp = int_sp;
        CPU.fp = int_fp;
        CPU.ra = int_ra;
        hm = CPU.get_registers_state();
    }

    @Test
    void get_zero() {
        assertEquals(int_zero, hm.get(zero));
    }

    @Test
    void get_at() {
        assertEquals(int_at, hm.get(at));
    }

    @Test
    void get_v0() {
        assertEquals(int_v0, hm.get(v0));
    }

    @Test
    void get_v1() {
        assertEquals(int_v1, hm.get(v1));
    }

    @Test
    void get_a0() {
        assertEquals(int_a0, hm.get(a0));
    }

    @Test
    void get_a1() {
        assertEquals(int_a1, hm.get(a1));
    }

    @Test
    void get_a2() {
        assertEquals(int_a2, hm.get(a2));
    }

    @Test
    void get_a3() {
        assertEquals(int_a3, hm.get(a3));
    }

    @Test
    void get_t0() {
        assertEquals(int_t0, hm.get(t0));
    }

    @Test
    void get_t1() {
        assertEquals(int_t1, hm.get(t1));
    }

    @Test
    void get_t2() {
        assertEquals(int_t2, hm.get(t2));
    }

    @Test
    void get_t3() {
        assertEquals(int_t3, hm.get(t3));
    }

    @Test
    void get_t4() {
        assertEquals(int_t4, hm.get(t4));
    }

    @Test
    void get_t5() {
        assertEquals(int_t5, hm.get(t5));
    }

    @Test
    void get_t6() {
        assertEquals(int_t6, hm.get(t6));
    }

    @Test
    void get_t7() {
        assertEquals(int_t7, hm.get(t7));
    }

    @Test
    void get_s0() {
        assertEquals(int_s0, hm.get(s0));
    }

    @Test
    void get_s1() {
        assertEquals(int_s1, hm.get(s1));
    }

    @Test
    void get_s2() {
        assertEquals(int_s2, hm.get(s2));
    }

    @Test
    void get_s3() {
        assertEquals(int_s3, hm.get(s3));
    }

    @Test
    void get_s4() {
        assertEquals(int_s4, hm.get(s4));
    }

    @Test
    void get_s5() {
        assertEquals(int_s5, hm.get(s5));
    }

    @Test
    void get_s6() {
        assertEquals(int_s6, hm.get(s6));
    }

    @Test
    void get_s7() {
        assertEquals(int_s7, hm.get(s7));
    }

    @Test
    void get_t8() {
        assertEquals(int_t8, hm.get(t8));
    }

    @Test
    void get_t9() {
        assertEquals(int_t9, hm.get(t9));
    }

    @Test
    void get_k0() {
        assertEquals(int_k0, hm.get(k0));
    }

    @Test
    void get_k1() {
        assertEquals(int_k1, hm.get(k1));
    }

    @Test
    void get_gp() {
        assertEquals(int_gp, hm.get(gp));
    }

    @Test
    void get_sp() {
        assertEquals(int_sp, hm.get(sp));
    }

    @Test
    void get_fp() {
        assertEquals(int_fp, hm.get(fp));
    }

    @Test
    void get_ra() {
        assertEquals(int_ra, hm.get(ra));
    }

}