pragma solidity ^0.6.12;
pragma solidity >=0.6.12;
pragma solidity <=0.6.12;
pragma solidity ~0.6.12;
pragma solidity =0.6.12;

contract MyContract{
    uint oneEther = 10000000000000000000;// too many digits
    uint transferEth= 10000000000000000000;
    uint256 private interestRate=5; // 5% interest rate
    uint256 public transactionAmount = 1000000 ether; // 1 million ETH 
    address public myAddress;
    constructor() public {
        myAddress = 0x0000000000000000000000000000000000000000;//zero address 
    }
    function setMyAddress(address _newAddress) public {
        myAddress = _newAddress;
    }
    function calculateInterest() public view returns (uint256) {
	return transactionAmount * interestRate;
     }

}

contract MyContract1{
    address public myAddress1;
    
    constructor() public {
        myAddress1 = 0x000000000000000000000000000000000000123;//incorrect address
    }
    
    function setMyAddress(address _newAddress) public {
        myAddress1 = _newAddress;
    }
}