/**
 * Author:  JGilson
 * Created: 14/04/2018
 */

USE eagle;

ALTER TABLE _order
  ADD created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;