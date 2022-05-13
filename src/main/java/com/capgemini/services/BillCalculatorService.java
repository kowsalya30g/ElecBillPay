package com.capgemini.services;

import org.springframework.stereotype.Service;
import com.capgemini.model.ConnectionType;

@Service
public class BillCalculatorService {

	//NON_INDUSTRIAL, INDUSTRIAL, AGRICULTURAL
	private ConnectionType connectionType;

	public double calculateBill(int unitsConsumed,ConnectionType type)
	{
		if(type.equals(connectionType.NON_INDUSTRIAL))
			return calculateBillForNonIndustrial(unitsConsumed);
		else if(type.equals(connectionType.INDUSTRIAL))
			return calculateBillForIndustrial(unitsConsumed);
		return calculateBillForAgricultural(unitsConsumed);


	}

	private double calculateBillForAgricultural(int unitsConsumed) {
		// TODO Auto-generated method stub

		/* cost of unit for first 50 units is 1.95
		 * cost of unit for next 50 units is 3.10
		 * cost of unit above 100 units is 5.25
		 */

		if(unitsConsumed<=50)
			return unitsConsumed*1.95;
		else if(unitsConsumed<=100)
			return (50*1.95)+(unitsConsumed-50)*3.10;
		return (50*1.95)+(50*3.10)+(unitsConsumed-100)*5.25;



	}

	private double calculateBillForIndustrial(int unitsConsumed) {
		// TODO Auto-generated method stub

		/* cost of unit for first 200 units is 5.10
		 * cost of unit for next 100 units is 7.70
		 * cost of unit for next 100 units is 9.0
		 * cost of unit for next 400 units is 9.5
		 * cost of unit above 800 units is 10.00
		 */

		if(unitsConsumed<=200)
			return unitsConsumed*5.10;
		else if(unitsConsumed<=300)
			return (200*5.10)+(unitsConsumed-200)*7.70;
		else if(unitsConsumed<=400)
			return (200*5.10)+(100*7.70)+(unitsConsumed-300)*9.0;
		else if(unitsConsumed<=800)
			return (200*5.10)+(100*7.70)+(100*9.0)+(unitsConsumed-400)*9.5;

		return (200*5.10)+(100*7.70)+(100*9.0)+(400*9.5)+(unitsConsumed-800)*10.0;
	}

	private double calculateBillForNonIndustrial(int unitsConsumed) {
		// TODO Auto-generated method stub

		/* cost of unit for first 100 units is 3.40
		 * cost of unit for next 100 units is 4.80
		 * cost of unit above 200 units is 6.70
		 */

		if(unitsConsumed<=100)
			return unitsConsumed*3.4;
		else if(unitsConsumed<=200)
			return (100*3.4)+(unitsConsumed-100)*4.8;
		return (100*3.4)+(100*4.8)+(unitsConsumed-200)*6.70;
	}

}
