import React from 'react'
import abc from '../img/abc.png'
import hrc_logo from '../img/hrc_logo.png'
export default function Header() {
    return (

        <div className='photuu' >
            <div className='hrc_logo'>
                <img id='abc' src={abc} alt ="image1"></img>
            </div>
            <div className='hrc_logo'>
                <img id='hrc_logo' src={hrc_logo} alt ="image2"></img>
            </div>
           <div className='hrc_logo'>

           </div>
        </div>
    )
}
