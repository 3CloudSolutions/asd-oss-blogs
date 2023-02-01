import React, { useReducer } from 'react';
import {useLocation, Route, NavLink, Routes} from 'react-router-dom';
import '../styling/Table.css';
import Houses from "../house/Houses";

function Home() {
    const path = useLocation();
    const [state, dispatch] = useReducer((state, action) => {
            switch(action.type) {
                case 'houses':
                    return { houses: true };
                default:
                    return { houses: true };
            }
        }
        , { houses: true }
    );

    return (
        <>
            <div className="row">
                <div className="column-nav">
                    <div>Navigation bar:</div>
                    <ul>
                        <li><NavLink to="home" className={(navData) => navData.isActive ? 'active' : 'link' }>Home</NavLink></li>
                        <li><NavLink to="houses" className={(navData) => navData.isActive ? 'active' : 'link' }>Houses</NavLink></li>
                    </ul>
                </div>

                <div className="column-content">
                    <Routes>
                        <Route path="home" element={<div>Select a navigation</div>} />
                        <Route path="houses" element={<Houses isActive={"true"}/>} />
                    </Routes>
                </div>
            </div>
        </>
    );
}

export default Home;
