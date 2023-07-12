import React, { useState } from 'react';

const NumberPlusMinus = () => {

const [count, setCount] = useState(0);


return(

    <div className='wrapper'>
        <button className='minus' onClick={() => setCount(count -1)}>-</button>
        <h3 className='count'>{count}</h3>
        <button className='plus' onClick={() => setCount(count +1)}>+</button>
    </div>

    

);

}









export default NumberPlusMinus;
