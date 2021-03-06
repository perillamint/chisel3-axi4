package moe.silicon.fpga.openip.axi4.io

import chisel3._
import moe.silicon.fpga.openip.axi4.AXI4Param

// NOTE: Reference doc: http://www.gstitt.ece.ufl.edu/courses/fall15/eel4720_5721/labs/refs/AXI4_specification.pdf

class AXI4MasterBundle(param: AXI4Param) extends Bundle {
  // AXI4 Master IO

  // should we use this...?
  // val clk     = Input(Clock())

  // AW channel
  val awaddr  = Output(UInt(param.addrWidth.W))
  val awlen   = Output(UInt(param.burstWidth.W))
  val awsize  = Output(UInt(3.W)) // TODO: Make it configurable?
  val awburst = Output(UInt(2.W))
  val awlock  = Output(UInt(2.W))
  val awcache = Output(UInt(4.W))
  val awprot  = Output(UInt(3.W))
  val awqos   = Output(UInt(4.W)) // See A8.1.1
  val awvalid = Output(Bool())
  val awready = Input(Bool())

  // W channel
  val wdata   = Output(UInt(param.dataWidth.W))
  // TODO: FIXME: is it right to calculate like this?
  val wstrb   = Output(UInt(((param.dataWidth + 7) / 8).W)) // See A10.3.4
  val wlast   = Output(Bool())
  val wvalid  = Output(Bool())
  val wready  = Input(Bool())

  // AR channel
  val araddr  = Output(UInt(param.addrWidth.W))
  val arlen   = Output(UInt(param.burstWidth.W))
  val arsize  = Output(UInt(3.W))
  val arburst = Output(UInt(2.W))
  val arlock  = Output(UInt(2.W))
  val arcache = Output(UInt(4.W))
  val arprot  = Output(UInt(3.W))
  val arqos   = Output(UInt(4.W)) // See A8.1.1
  val arvalid = Output(Bool())
  val arready = Input(Bool())

  // R channel
  val rdata   = Input(UInt(param.dataWidth.W))
  val rlast   = Output(Bool())
  val rvalid  = Output(Bool())
  val rready  = Output(Bool())

  // B channel
  val bid     = Input(UInt(param.idWidth.W))
  val bresp   = Input(UInt(2.W)) // TODO: Read the AXI4 spec
  val bvalid  = Input(Bool())
  val bready  = Output(Bool())
}

class AXI4SlaveBundle(param: AXI4Param) extends Bundle {
  // AXI4 Slave IO

  //val clk     = Input(Clock())

  // AW channel
  val awaddr  = Input(UInt(param.addrWidth.W))
  val awlen   = Input(UInt(param.burstWidth.W))
  val awsize  = Input(UInt(3.W)) // TODO: Make it configurable?
  val awburst = Input(UInt(2.W))
  val awlock  = Input(UInt(2.W))
  val awcache = Input(UInt(4.W))
  val awprot  = Input(UInt(3.W))
  val awid    = Input(UInt(param.idWidth.W))
  val awqos   = Input(UInt(4.W)) // See A8.1.1
  val awvalid = Input(Bool())
  val awready = Output(Bool())

  // W channel
  val wdata   = Input(UInt(param.dataWidth.W))
  // TODO: FIXME: is it right to calculate like this?
  val wstrb   = Input(UInt(((param.dataWidth + 7) / 8).W)) // See A10.3.4
  val wlast   = Input(Bool())
  val wvalid  = Input(Bool())
  val wready  = Output(Bool())

  // AR channel
  val araddr  = Input(UInt(param.addrWidth.W))
  val arlen   = Input(UInt(param.burstWidth.W))
  val arsize  = Input(UInt(3.W))
  val arburst = Input(UInt(2.W))
  val arlock  = Input(UInt(2.W))
  val arcache = Input(UInt(4.W))
  val arprot  = Input(UInt(3.W))
  val arid    = Input(UInt(param.idWidth.W))
  val arqos   = Input(UInt(4.W)) // See A8.1.1
  val arvalid = Input(Bool())
  val arready = Output(Bool())

  // R channel
  val rdata   = Output(UInt(param.dataWidth.W))
  val rid     = Output(UInt(param.idWidth.W))
  val rlast   = Input(Bool())
  val rvalid  = Output(Bool())
  val rready  = Input(Bool())

  // B channel
  val bid     = Output(UInt(param.idWidth.W))
  val bresp   = Output(UInt(2.W)) // TODO: Read the AXI4 spec
  val bvalid  = Output(Bool())
  val bready  = Input(Bool())
}

//class AXI_AWID
