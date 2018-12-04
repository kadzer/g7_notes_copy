import React  from 'react';
import moment from 'moment'

const Pirate = (props) => {
	let date = new Date(props.pirate.joinDate);
	let formattedDate = moment(date).format("DD/MM/YY");

		const url = "/pirates/" + props.pirate.id
		return (
				<div className="component">
					<a href={url}>
					<p className="name">
						{props.pirate.firstName} {props.pirate.lastName}
					</p>
					</a>
					<p>Age: {props.pirate.age}</p>
					<p>Ship: {props.pirate.ship.name}</p>
					<p>Join Date: {formattedDate}</p>

				</div>
		)
	}

export default Pirate;
