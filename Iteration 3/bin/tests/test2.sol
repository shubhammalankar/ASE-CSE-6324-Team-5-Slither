pragma solidity ^0.8.19;
contract contractAuction {

    address payable addr;
    address payable currentLeader;
    uint256 highestBid;
    address payable[] refundAddresses;
    uint x;
    
    uint y;
    function bid() public payable {

         for (uint i = 0; currentLeader.send(highestBid)==true; i++) {
            refundAddresses[i].transfer(1 wei);
            addr.transfer(1 wei);
        }

         for (uint j = 0; currentLeader.send(highestBid)==true; j++) {
            refundAddresses[j].transfer(1 wei);
            addr.transfer(1 wei);
        }


        while (currentLeader.send(highestBid)==true) {
            if(x > refundAddresses[x].transfer(1 wei))
                refundAddresses[x].transfer(1 wei);

        }

        while (currentLeader.send(highestBid)==true) {
            if(y > refundAddresses[y].transfer(1 wei))
                refundAddresses[y].transfer(1 wei);

        }
    } 
}
