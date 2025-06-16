-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 16/06/2025 às 05:39
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `academia`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Cargo` varchar(30) DEFAULT NULL,
  `Login` varchar(30) NOT NULL,
  `Senha` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `funcionarios`
--

INSERT INTO `funcionarios` (`ID`, `Nome`, `Cargo`, `Login`, `Senha`) VALUES
(1, 'Carlos Mendes', 'Administrador', 'carlosadm', 'senha123'),
(2, 'Ana Lima', 'Recepcionista', 'ana.lima', 'ana@123'),
(3, 'João Ferreira', 'Instrutor', 'joao.ferreira', 'joao2025'),
(4, 'Patrícia Nogueira', 'Gerente', 'pat.nogueira', 'patricia@adm'),
(5, 'Lucas Almeida', 'Administrador', 'lucas.almeida', 'lucas@admin'),
(6, 'Fernanda Souza', 'Financeiro', 'fernanda.s', 'finance123'),
(7, 'Rafael Costa', 'Instrutor', 'rafael.costa', 'senha@2025'),
(8, 'Isabela Martins', 'RH', 'isa.martins', 'rh@isabela'),
(9, 'Bruno Silva', 'Instrutor', 'bruno.silva', 'instrutor@2025');

-- --------------------------------------------------------

--
-- Estrutura para tabela `historico_atividades`
--

CREATE TABLE `historico_atividades` (
  `ID` int(11) NOT NULL,
  `ID_Membro` int(11) DEFAULT NULL,
  `Atividade` varchar(100) DEFAULT NULL,
  `Data` date DEFAULT NULL,
  `Tempo_Execucao` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `historico_atividades`
--

INSERT INTO `historico_atividades` (`ID`, `ID_Membro`, `Atividade`, `Data`, `Tempo_Execucao`) VALUES
(1, 1, 'Supino reto', '2025-06-10', '180:00:00'),
(2, 1, 'Rosca direta', '2025-06-10', '150:00:00'),
(3, 1, 'Tríceps testa', '2025-06-10', '120:00:00'),
(4, 2, 'Agachamento livre', '2025-06-11', '210:00:00'),
(5, 2, 'Leg press', '2025-06-11', '180:00:00'),
(6, 2, 'Cadeira extensora', '2025-06-11', '150:00:00'),
(7, 3, 'Puxada frontal', '2025-06-12', '160:00:00'),
(8, 3, 'Remada baixa', '2025-06-12', '170:00:00'),
(9, 3, 'Levantamento terra', '2025-06-12', '200:00:00'),
(10, 4, 'Bicicleta ergométrica', '2025-06-13', '90:00:00'),
(11, 4, 'Esteira', '2025-06-13', '120:00:00'),
(12, 4, 'Abdominal solo', '2025-06-13', '60:00:00'),
(13, 5, 'Elevação lateral', '2025-06-14', '130:00:00'),
(14, 5, 'Desenvolvimento com halteres', '2025-06-14', '150:00:00'),
(15, 5, 'Encolhimento de ombros', '2025-06-14', '110:00:00'),
(16, 6, 'Corrida na esteira', '2025-06-14', '180:00:00'),
(17, 6, 'Flexão de braço', '2025-06-14', '60:00:00'),
(18, 6, 'Prancha abdominal', '2025-06-14', '90:00:00'),
(19, 7, 'Puxada atrás', '2025-06-14', '170:00:00'),
(20, 7, 'Remada curvada', '2025-06-14', '160:00:00'),
(21, 7, 'Crucifixo reto', '2025-06-14', '140:00:00'),
(22, 8, 'Agachamento sumô', '2025-06-14', '190:00:00'),
(23, 8, 'Afundo com halteres', '2025-06-14', '150:00:00'),
(24, 8, 'Panturrilha em pé', '2025-06-14', '130:00:00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `membros`
--

CREATE TABLE `membros` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `CPF` varchar(14) NOT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Data_Cadastro` date DEFAULT NULL,
  `Senha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `membros`
--

INSERT INTO `membros` (`ID`, `Nome`, `CPF`, `Telefone`, `Email`, `Data_Cadastro`, `Senha`) VALUES
(1, 'Amanda Silva', '123.456.789-00', '(11) 91234-5678', 'amanda.silva@example.com', '2025-06-15', 'amanda@123'),
(2, 'Bruno Carvalho', '987.654.321-00', '(21) 99876-5432', ' bruno.carvalho@example.com', '2025-06-15', 'bruno@2025'),
(3, 'Juliana Rocha', '321.987.654-11', '(31) 98555-1122', 'juliana.rocha@example.com', '2025-06-15', ' juliana123'),
(4, 'Felipe Martins', '456.123.789-22', '(41) 99777-3344', 'felipe.martins@example.com', '2025-06-15', 'felipe@secure'),
(5, 'Fernando Costa', '963.258.147-11', '(91) 92222-7788', 'fernando.costa@example.com', '2025-06-15', 'fernando@123'),
(6, 'Fernando Costa', '963.258.237-11', '(91) 92222-7788', 'fernando.costa@example.com', '2025-06-15', 'fernando@123'),
(7, 'Thiago Pereira', '987.654.321-30', '(21) 98888-1122', 'thiago.pereira@example.com', '2025-06-15', 'thiago@2025'),
(8, 'Camila Ramos', '456.789.123-99', '(31) 97777-2233', 'camila.ramos@example.com', '2025-06-15', 'camila@senha'),
(9, 'Diego Silva', '321.654.987-55', '(41) 96666-3344', 'diego.silva@example.com', '2025-06-15', 'diegosilva'),
(10, 'Vanessa Oliveira', '741.852.963-44', '(71) 95555-4455', 'vanessa.oliveira@example.com', '2025-06-15', 'vanessa123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `pagamentos`
--

CREATE TABLE `pagamentos` (
  `ID` int(11) NOT NULL,
  `ID_Membro` int(11) DEFAULT NULL,
  `Valor` decimal(10,2) DEFAULT NULL,
  `Data_Pagamento` date DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `pagamentos`
--

INSERT INTO `pagamentos` (`ID`, `ID_Membro`, `Valor`, `Data_Pagamento`, `Status`) VALUES
(1, 1, 99.90, '2025-02-10', 'PAGO'),
(2, 1, 99.90, '2025-03-10', 'PAGO'),
(3, 1, 99.90, '2025-04-10', 'PAGO'),
(4, 1, 99.90, '2025-05-10', 'PAGO'),
(5, 1, 99.90, '2025-06-15', 'PAGO'),
(6, 2, 99.90, '2025-02-15', 'PAGO'),
(7, 2, 99.90, '2025-03-15', 'PAGO'),
(8, 2, 99.90, '2025-06-15', 'PAGO'),
(9, 2, 99.90, '2025-05-15', 'PAGO'),
(10, 2, 99.90, '2025-06-15', 'PAGO'),
(11, 3, 99.90, '2025-01-20', 'PAGO'),
(12, 3, 99.90, '2025-02-20', 'PAGO'),
(13, 3, 99.90, '2025-03-20', 'PAGO'),
(14, 3, 99.90, '2025-04-20', 'PAGO'),
(15, 3, 99.90, '2025-05-20', 'PAGO'),
(16, 4, 99.90, '2025-03-01', 'PAGO'),
(17, 4, 99.90, '2025-06-15', 'PAGO'),
(18, 4, 99.90, '2025-05-01', 'PAGO'),
(19, 4, 99.90, '2025-06-01', 'EM ABERTO'),
(20, 4, 99.90, '2025-06-10', 'EM ABERTO'),
(21, 5, 99.90, '2025-02-28', 'PAGO'),
(22, 5, 99.90, '2025-03-28', 'PAGO'),
(23, 5, 99.90, '2025-06-15', 'PAGO'),
(24, 5, 99.90, '2025-05-28', 'PAGO'),
(25, 5, 99.90, '2025-06-14', 'EM ABERTO'),
(26, 6, 99.90, '2025-03-05', 'PAGO'),
(27, 6, 99.90, '2025-04-05', 'PAGO'),
(28, 6, 99.90, '2025-05-05', 'PAGO'),
(29, 6, 99.90, '2025-06-05', 'PAGO'),
(30, 6, 99.90, '2025-06-15', 'EM ABERTO'),
(31, 7, 99.90, '2025-01-12', 'PAGO'),
(32, 7, 99.90, '2025-02-12', 'PAGO'),
(33, 7, 99.90, '2025-03-12', 'PAGO'),
(34, 7, 99.90, '2025-04-12', 'ATRASADO'),
(35, 7, 99.90, '2025-05-12', 'EM ABERTO'),
(36, 8, 99.90, '2025-02-22', 'PAGO'),
(37, 8, 99.90, '2025-03-22', 'PAGO'),
(38, 8, 99.90, '2025-04-22', 'PAGO'),
(39, 8, 99.90, '2025-05-22', 'EM ABERTO'),
(40, 8, 99.90, '2025-06-22', 'EM ABERTO');

-- --------------------------------------------------------

--
-- Estrutura para tabela `treinos`
--

CREATE TABLE `treinos` (
  `ID` int(11) NOT NULL,
  `ID_Membro` int(11) DEFAULT NULL,
  `Tipo` varchar(50) DEFAULT NULL,
  `Descricao` text DEFAULT NULL,
  `Duracao` time DEFAULT NULL,
  `Data_Inicio` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `treinos`
--

INSERT INTO `treinos` (`ID`, `ID_Membro`, `Tipo`, `Descricao`, `Duracao`, `Data_Inicio`) VALUES
(1, 1, 'Superiores', 'Treino focado em peito, ombros e tríceps. Inclui supino, desenvolvimento e tríceps testa.', '01:10:00', '2025-06-10'),
(2, 1, 'Inferiores', 'Agachamento livre, leg press e stiff.', '01:20:00', '2025-06-12'),
(3, 2, 'Costas e Bíceps', 'Puxada frontal, remada baixa, rosca direta e rosca martelo.', '01:15:00', '2025-06-11'),
(4, 2, 'Cardio', 'Esteira, bicicleta ergométrica e escada.', '00:50:00', '2025-06-13'),
(5, 3, 'Ombros e Abdômen', 'Desenvolvimento com halteres, elevação lateral, abdominal solo e prancha.', '01:00:00', '2025-06-12'),
(6, 4, 'Superiores', 'Supino reto, crucifixo, tríceps pulley e rosca direta.', '01:10:00', '2025-06-13'),
(7, 5, 'Inferiores', 'Agachamento, cadeira extensora, panturrilha no leg press.', '01:25:00', '2025-06-14'),
(8, 6, 'Full Body', 'Treino geral com exercícios para o corpo todo: agachamento, supino, remada, abdominal.', '01:30:00', '2025-06-13'),
(9, 7, 'Treino Funcional', 'Circuito funcional com corrida, flexão, saltos, prancha e agilidade.', '00:55:00', '2025-06-14'),
(10, 8, 'Posteriores', 'Stiff, mesa flexora, levantamento terra e glúteo no cabo.', '01:15:00', '2025-06-14');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Login` (`Login`);

--
-- Índices de tabela `historico_atividades`
--
ALTER TABLE `historico_atividades`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Membro` (`ID_Membro`);

--
-- Índices de tabela `membros`
--
ALTER TABLE `membros`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `CPF` (`CPF`);

--
-- Índices de tabela `pagamentos`
--
ALTER TABLE `pagamentos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Membro` (`ID_Membro`);

--
-- Índices de tabela `treinos`
--
ALTER TABLE `treinos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Membro` (`ID_Membro`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `historico_atividades`
--
ALTER TABLE `historico_atividades`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de tabela `membros`
--
ALTER TABLE `membros`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de tabela `pagamentos`
--
ALTER TABLE `pagamentos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de tabela `treinos`
--
ALTER TABLE `treinos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `historico_atividades`
--
ALTER TABLE `historico_atividades`
  ADD CONSTRAINT `historico_atividades_ibfk_1` FOREIGN KEY (`ID_Membro`) REFERENCES `membros` (`ID`) ON DELETE CASCADE;

--
-- Restrições para tabelas `pagamentos`
--
ALTER TABLE `pagamentos`
  ADD CONSTRAINT `pagamentos_ibfk_1` FOREIGN KEY (`ID_Membro`) REFERENCES `membros` (`ID`) ON DELETE CASCADE;

--
-- Restrições para tabelas `treinos`
--
ALTER TABLE `treinos`
  ADD CONSTRAINT `treinos_ibfk_1` FOREIGN KEY (`ID_Membro`) REFERENCES `membros` (`ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
