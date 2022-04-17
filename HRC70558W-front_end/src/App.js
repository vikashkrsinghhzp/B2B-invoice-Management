import './App.css';
import DataTable from './Components/DataTable';
import Header from './Components/Header';
import { Button, ButtonGroup } from '@mui/material';
import Bottom from './Components/Bottom';
import { useState } from 'react';
import AddData from './Components/AddData'
import Edit from './Components/Edit'
import Delete from './Components/Delete'
import AdvanceSearch from './Components/AdvanceSearch';

const Style = {
  color: 'white',
  borderRadius: 10,
  height: "40px",
  backgroundColor: "#2c4350"
}



function App() {
  const [openadd, setOpenadd] = useState(false);

  const handleAddOpen = () => {
    setOpenadd(true);
  };

  const handleAddClose = () => {
    setOpenadd(false);
  };
  const [openedit, setOpenedit] = useState(false);

  const handleEditOpen = () => {
    setOpenedit(true);
  };

  const handleEditClose = () => {
    setOpenedit(false);
  };
  const [opendelete, setOpendelete] = useState(false);

  const handleDeleteOpen = () => {
    setOpendelete(true);
  };

  const handleDeleteClose = () => {
    setOpendelete(false);
  };
  const [openAdavnceSearch, setOpenAdvanceSearch] = useState(false);

  const handleAdvanceSearchOpen = () => {
    setOpenAdvanceSearch(true);
  };

  const handleAdvanceSearchClose = () => {
    setOpenAdvanceSearch(false);
  };
  return (
    <div className="App">
      
        <Header />

        <h3 style={{ textAlign: "left", marginLeft: 10, marginBottom: 10, color: 'white' }}>Invoice List</h3>
        <div className='btn-group' style={{ marginLeft: 10}}>
          <ButtonGroup style={{
            color: 'white',
            borderRadius: 10,
            height: "40px",
            backgroundColor: "#2c4350"
          }} variant="outlined" aria-label="outlined button group">
            <Button style={{ background: "#87CEEB", width:"215px", color: 'white'}}>PREDICT</Button>
            <Button style={{width:"215px", color: 'white'}}>ANALYTICS VIEW</Button>
            <Button style={{width:"215px", color: 'white'}} onClick={handleAdvanceSearchOpen}>ADVANCE SEARCH</Button>
          </ButtonGroup>


          <input style={{margin:"0px 20px 0px 5px"}} type="text" id="search-bar" placeholder='Search Custumer Id'/>

          <ButtonGroup style={Style}  variant="outlined" aria-label="outlined button group">
            <Button style={{width:"165px", color: 'white'}} onClick={handleAddOpen}>ADD</Button>
            <Button style={{width:"165px", borderColor:"black" , margin:"0px 5px", color: 'white'}} onClick={handleEditOpen}>EDIT</Button>
            <Button style={{width:"165px", color: 'white'}} onClick={handleDeleteOpen}>DELETE</Button>
          </ButtonGroup>
          
        </div>
          <AddData open={openadd} close={()=>handleAddClose()} />
          <Edit open={openedit} close={()=>handleEditClose()} />
          <Delete open={opendelete} close={()=>handleDeleteClose()} />
          <AdvanceSearch open={openAdavnceSearch} close={()=>handleAdvanceSearchClose()} />
      <br />
      <DataTable />
      <Bottom />
    </div>
  );
}

export default App;
