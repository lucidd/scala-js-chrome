package chrome

case class Udp(bind: Set[String] = Set(), send: Set[String] = Set(), multicastMembership: Set[String] = Set())

case class Tcp(connect: Set[String] = Set(), listen: Set[String] = Set())

case class Sockets(udp: Option[Udp] = None, tcp: Option[Tcp] = None)
