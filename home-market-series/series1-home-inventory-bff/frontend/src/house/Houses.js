import React, { useEffect, useState } from "react";

function Houses() {

    const [house, setHouse] = useState({});

    useEffect(()=> {
        console.log(`Fecthing data`);
        fetch(`http://localhost:8080/api/v1/houses/1`)
            .then((response) => response.json())
            .then((data) => setHouse(data))
        ;
    }, []);

    return (
        <>
            <div className="base">
                Welcome to the rental dashboard!
            </div>

            <div className="house-details">
                <h4>Information about the homes: </h4>
                <p>Name: {house.name ? house.name : "Loading"}</p>
                <p>City: {house.city ? house.city : "Loading"}</p>
                <p>State: {house.state ? house.state : "Loading"}</p>
            </div>

            <div className="inventory">
                Here's the inventory list of supplies:
            </div>
        </>

    );
}

export default Houses;
