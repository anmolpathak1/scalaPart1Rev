package lectures.part2oop


/*
* enum are data type - that can be defined much like a class.
*  that will have only a bunch of instances that we create in inside enum.*/
object Enums extends App{

  /*
  * only possible instances of Permission are READ,WRITE,EXECUTE,NONE*/
  enum Permission{
    case READ,WRITE,EXECUTE,NONE


    // add fields/Methods

    def openDocument(): Unit = {
      if (this == READ) println("opening document..")
      else print("read not allowed.")
    }
  }

  //constructor args
  enum PermissionWithBits(bits : Int){
    case READ extends PermissionWithBits(4)
    case WRITE extends PermissionWithBits(2)
    case EXECUTE extends PermissionWithBits(1)
    case NONE extends PermissionWithBits(0)
  }

  object PermissionWithBits{
    def fromBits(bits : Int) : PermissionWithBits =
      PermissionWithBits.NONE
  }

  val ReadPermission : Permission = Permission.READ
  val WritePermission: Permission = Permission.WRITE

  //STANDARD API.
  val ReadPermissionsOrdinal = ReadPermission.ordinal
  val writePermissionOrdinal = WritePermission.ordinal
  val allPermission = PermissionWithBits.values
  val ExecutePermission : Permission = Permission.valueOf("READ")

  ReadPermission.openDocument()
  WritePermission.openDocument()

}
