package com.dslplatform.webcamp2014

object Main extends App {
  // TODO: Your code here

  Populator.neronize()
  Populator.populate()

  // Perform cleanup.
  shutdown()
}
