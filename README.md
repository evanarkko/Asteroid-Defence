# Asteroid-Defence
Small game development project for job application

INSTRUCTIONS:<br />
-spawn new asteroid with a click&drag motion<br />
-Changeable constants are: missile velocity, asteroid velocity<br /> 
 and Safety Zone radius.<br />
	-All are static fields of Missile, Asteroid and Earth Classes<br />
	-you can change them in the code and the mechanics still work<br />
-Turret will intercept each and every asteroid that is possible with<br />
 given velocities and spwaning position <br />
	-Every now and then the turret will shoot and miss badly but<br />
	 only in a stiuation where interception was impossible.<br />

"Your working implementation should include two methods with the following (or similar) signatures:"<br />
• bool TrajectoryWithinSafetyZone(Vector3 asteroidPosition, Vector3 asteroidVelocity)<br />
	-LOCATED IN src/physics/Collider.java on line 22<br />
• Vector3 CalculateMissileVelocity(Vector3 asteroidPosition, Vector3 asteroidVelocity)<br />
	-LOCATED IN src/characters.turretry/Turret.java on line 54<br />
	-signature changed to ...Vector(..) instead of ...Velocity(..)<br />
	  because velocity is constant for missiles. <br />
	-also changed to void- type because that made sense in my<br /> 
	 implementation<br />
