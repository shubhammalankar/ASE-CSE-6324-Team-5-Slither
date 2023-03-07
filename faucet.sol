pragma solidity ^0.8.17;

contract ShadowingInFunctions {
    uint Rushikesh__1 = 2;
    uint Rushikesh__2 = 3;

    function test1() public returns (uint Rushikesh__1) {
        return Rushikesh__1; // Will return 0
    }

    function test2() public returns (uint Rushikesh__1) {
        Rushikesh__1 = 1;
        return Rushikesh__1; // Will return 1
    }

    function test3() public returns (uint Rushikesh__2) {
        uint Rushikesh__1 = 4;
        return Rushikesh__1+Rushikesh__2; // Will return 4
    }
	    function test4() public returns (uint Rushikesh__1) {
        return Rushikesh__1; // Will return 1
    }

    function test5() public returns (uint Rushikesh__1) {
        Rushikesh__1 = 2;
        return Rushikesh__1; // Will return 2
    }

    function test6() public returns (uint Rushikesh__2) {
        uint Rushikesh__1 = 6;
        return Rushikesh__1+Rushikesh__2; // Will return 6
    }
		    function test7() public returns (uint Rushikesh__1) {
        return Rushikesh__1; // Will return 1
    }

    function test8() public returns (uint Rushikesh__1) {
        Rushikesh__1 = 8;
        return Rushikesh__1; // Will return 8
    }

    function test9() public returns (uint Rushikesh__2) {
        uint Rushikesh__1 = 9;
        return Rushikesh__1+Rushikesh__2; // Will return 9
    }
}