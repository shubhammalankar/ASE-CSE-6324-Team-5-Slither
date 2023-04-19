pragma solidity ^0.8.19;

contract A {
    uint oldSupply;
	uint interset;
    uint coins;
    function f(uint n) public {
        coins = (oldSupply / n) * interset;
    }
}