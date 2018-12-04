import React, {Component} from 'react';

class PirateFormContainer extends Component {
  constructor(props){
    super(props);
    this.state = { ships: []};
  }

  componentDidMount(){
    fetch('/ships')
    .then((res) => res.json())
    .then((data) => {
      this.setState({ships: data._embedded.ships})
    })
  }

  handleSubmit(event){
    event.preventDefault();
    fetch("/pirates", {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({
        "firstName": event.target.firstName.value,
        "lastName": event.target.lastName.value,
        "age": event.target.age.value,
        "joinDate": event.target.joinDate.value,
        "ship": event.target.ship.value
      })
    }).then(() => {
      window.location = "/pirates";
    })
  }

  render() {

    const options = this.state.ships.map((ship, index) => {
      return <option key={index} value={ship._links.self.href}>{ship.name}</option>
    })


    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <input type="text" placeholder="First Name" name="firstName"/>
          <input type="text" placeholder="Last Name" name="lastName"/>
          <input type="number" placeholder="Age" name="age"/>
          <select name="ship">
            {options}
          </select>
          <input type="date" name="joinDate" />
          <button type="submit">Save</button>
        </form>
      </div>
    )
  }

}

export default PirateFormContainer;
