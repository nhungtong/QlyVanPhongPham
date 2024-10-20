-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 03, 2024 lúc 04:39 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlvpp`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietnhap`
--

CREATE TABLE `chitietnhap` (
  `sohoadonN` varchar(50) NOT NULL,
  `mamathang` varchar(50) NOT NULL,
  `soluongN` int(100) NOT NULL,
  `dongiaN` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietxuat`
--

CREATE TABLE `chitietxuat` (
  `sohoadonX` varchar(50) NOT NULL,
  `mamathang` varchar(50) NOT NULL,
  `soluongX` int(100) NOT NULL,
  `dongiaX` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadonnhap`
--

CREATE TABLE `hoadonnhap` (
  `sohoadonnhap` varchar(50) NOT NULL,
  `ngaynhap` date NOT NULL,
  `mancc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadonxuat`
--

CREATE TABLE `hoadonxuat` (
  `sohoadonxuat` varchar(50) NOT NULL,
  `ngayxuathoadon` date NOT NULL,
  `manv` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mathang`
--

CREATE TABLE `mathang` (
  `mamathang` varchar(50) NOT NULL,
  `tenmathang` varchar(50) NOT NULL,
  `donvitinh` varchar(50) NOT NULL,
  `nhasx` varchar(50) NOT NULL,
  `chatlieu` varchar(50) NOT NULL,
  `anh` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `mathang`
--

INSERT INTO `mathang` (`mamathang`, `tenmathang`, `donvitinh`, `nhasx`, `chatlieu`, `anh`) VALUES
('mh01', 'Ghế nhựa', 'VNĐ', 'FAHA', 'nhựa', 'D:/JAVA/asset/_mh01ghe-nhua-tra-chanh-sx4-2.jpg'),
('mh02', 'Cốc', 'VNĐ', 'Rạng Đông', 'thủy tinh', 'D:/JAVA/asset/_mh02coc-lien-xo-be-6329.jpg'),
('mh03', 'Nồi cơm điện', 'VNĐ', 'Supor', 'nhôm', 'D:/JAVA/asset/_mh03noi-com-dien.jpg'),
('mh04', 'Ấm siêu tốc', 'VNĐ', 'Roler', 'nhôm', 'D:/JAVA/asset/_mh04am-sieu-toc.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `mancc` varchar(50) NOT NULL,
  `tenncc` varchar(50) NOT NULL,
  `diachi` varchar(50) NOT NULL,
  `dienthoai` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhavien`
--

CREATE TABLE `nhavien` (
  `manv` varchar(50) NOT NULL,
  `tennv` varchar(50) NOT NULL,
  `dienthoai` varchar(15) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhavien`
--

INSERT INTO `nhavien` (`manv`, `tennv`, `dienthoai`, `pass`) VALUES
('nv01', 'Nguyễn Văn An', '7263', 'nv01'),
('nv02', 'Nguyễn Thị Bích', '28734', 'nv02'),
('nv03', 'Hoàng Thành Nam', '45645', 'nv03');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietnhap`
--
ALTER TABLE `chitietnhap`
  ADD PRIMARY KEY (`sohoadonN`,`mamathang`);

--
-- Chỉ mục cho bảng `chitietxuat`
--
ALTER TABLE `chitietxuat`
  ADD PRIMARY KEY (`sohoadonX`,`mamathang`);

--
-- Chỉ mục cho bảng `hoadonnhap`
--
ALTER TABLE `hoadonnhap`
  ADD PRIMARY KEY (`sohoadonnhap`),
  ADD KEY `mancc` (`mancc`);

--
-- Chỉ mục cho bảng `hoadonxuat`
--
ALTER TABLE `hoadonxuat`
  ADD PRIMARY KEY (`sohoadonxuat`),
  ADD KEY `manv` (`manv`);

--
-- Chỉ mục cho bảng `mathang`
--
ALTER TABLE `mathang`
  ADD PRIMARY KEY (`mamathang`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`mancc`);

--
-- Chỉ mục cho bảng `nhavien`
--
ALTER TABLE `nhavien`
  ADD PRIMARY KEY (`manv`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
