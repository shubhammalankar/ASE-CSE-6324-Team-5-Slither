pragma solidity 0.6.12;
pragma solidity ^0.6.12;
pragma solidity ~0.6.12;
pragma solidity >0.6.12;
pragma solidity >=0.6.12;
pragma solidity <0.6.12;
pragma solidity <=0.6.12;
pragma solidity =0.6.12;

contract MyContract{
    uint oneEther = 10000000000000000000;
    uint transferEth= 10000000000000000000;
    address public myAddress= 0x123456789012345678901234567890123456789;
    address public myAddress= 0x0000000000000000000000000000000000000000;
    uint256 public interestRate = 0.001; // 0.1% interest rate
    uint256 public transactionAmount = 1000000 ether; // 1 million ETH

    function calculateInterest() public view returns (uint256) {
	return transactionAmount * interestRate;
     }
}


