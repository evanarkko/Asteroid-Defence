# Asteroid-Defence
Small game development project for job application

INSTRUCTIONS:
-spawn new asteroid with a click&drag motion
-Changeable constants are: missile velocity, asteroid velocity 
 and Safety Zone radius.
	-All are static fields of Missile, Asteroid and Earth Classes
	-you can change them in the code and the mechanics still work
-Turret will intercept each and every asteroid that is possible with
 given velocities and spwaning position 
	-Every now and then the turret will shoot and miss badly but
	 only in a stiuation where interception was impossible.

"Your working implementation should include two methods with the following (or similar) signatures:"
• bool TrajectoryWithinSafetyZone(Vector3 asteroidPosition, Vector3 asteroidVelocity)
	-LOCATED IN src/physics/Collider.java on line 22
• Vector3 CalculateMissileVelocity(Vector3 asteroidPosition, Vector3 asteroidVelocity)
	-LOCATED IN src/characters.turretry/Turret.java on line 54
	-signature changed to ...Vector(..) instead of ...Velocity(..)
	  because velocity is constant for missiles. 
	-also changed to void- type because that made sense in my 
	 implementation
