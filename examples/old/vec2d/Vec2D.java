/**
 * Vectors in two-space.
 */
public class Vec2D
{
  // +----------------+----------------------------------------------
  // | Static methods |
  // +----------------+

  /**
   * Build a vector to the point (x,y)
   * @pre
   *   x != 0
   */
  public static Vec2D vectorTo(double x, double y) {
    return new Vec2D(Math.atan(y/x), Math.sqrt(x*x + y*y));
  } // vectorTo(double,double)


  // +--------+---------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The angle.
   */
  double theta;

  /**
   * The radius.
   */
  double radius;

  // +--------------+---------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new vector with angle _theta and radius _radius.
   */
  public Vec2D(double _theta, double _radius) {
    this.theta = _theta;
    this.radius = _radius;
  } // Vec2D(double, double)

  /**
   * Create a unit vector with angle _theta.
   */
  public Vec2D(double _theta)
  {
    this.theta = _theta;
    this.radius = 1.0;
  } // Vec2D(double)

  /**
   * Create a new vector from (0,0) to (x,y).
   */
  public Vec2D(int x, int y)
  {
    this.theta = Math.atan(((double) y)/((double) x));
    this.radius = Math.sqrt(x*x + y*y);
  } // Vec2D(int, int)

  // +---------+--------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine the radius of this vector.
   */
  public double getRadius() {
    return this.radius;
  } // getRadius()

  /**
   * Determine the angle of this vector from the positive x axis.
   */
  public double getTheta() {
    return this.theta;
  } // getTheta()

  /**
   * Compute the x position of the head of this vector.
   */
  public double getX() {
    return this.radius * Math.cos(this.theta);
  } // getX()

  /**
   * Compute the y position of the head of this vector.
   */
  public double getY() {
    return this.radius * Math.sin(this.theta);
  } // getX()

  /**
   * Create a new vector that is twice as long as this vector.
   */
  public Vec2D dubble() {
    return new Vec2D(this.getTheta(), this.getRadius()*2);
  } // dubble

  /**
   * Add another vector to this vector.
   */
  public Vec2D add(Vec2D addend) {
    return Vec2D.vectorTo((this.getX() + addend.getX()),
                          (this.getY() + addend.getY()));
  } // add(Vec2D)

} // class Vec2D
