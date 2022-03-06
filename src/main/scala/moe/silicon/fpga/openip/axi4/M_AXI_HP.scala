package moe.silicon.fpga.openip.axi4

import chisel3._
import chisel3.util.{switch, is}
import chisel3.experimental.ChiselEnum
import chisel3.stage.{ChiselStage, ChiselGeneratorAnnotation}

// ARM AXI High Performance interface (master)
class M_AXI_HP(param: AXI4Param) extends Module {
  val M_AXI = IO(new Bundle {
    val a = new Bundle {
      val foo = Input(Bool())
    }.suggestName("foo")
    val b = new Bundle {
      val bar = Input(Bool())
    }
  })
}
